package com.thefrodo.copyright

import androidx.compose.ui.res.useResource
import com.google.re2j.Pattern
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import org.apache.poi.xwpf.usermodel.XWPFDocument
import org.apache.poi.xwpf.usermodel.XWPFParagraph
import org.apache.poi.xwpf.usermodel.XWPFRun
import java.io.File
import java.io.FileInputStream
import java.io.FileOutputStream
import java.io.OutputStreamWriter
import java.nio.charset.Charset
import java.text.SimpleDateFormat
import java.util.*

object Generator {

    private const val version = "v1.0.0"

    private val CharSet = Charset.defaultCharset()

    private val mIncludeFiles = arrayOf("kt", "java", "swift", "cc")
    private val mExcludeDirs =
        arrayOf(".idea", "test", "components", "gradle", ".git", "build", ".gradle", "media", "jni", "assets")
    private val commentRegexA =
        Pattern.compile("(?:(package|import|\\/\\/)).*") //删除 package|import|// lines
    private val commentRegexB = Pattern.compile("\\/*(s|.)*?\\*\\/")  //删除 注释
    private val commentRegexC = Pattern.compile("(?m)^\\s*$(\n|\r\n)") //删除空行

    suspend fun doGenerator(
        input: File,
        output: File,
        maxDepth: Int = 10,
        maxFiles: Int = 10240,
        message: (String) -> Unit = {},
    ) = withContext(Dispatchers.IO) {
        val name = input.name
        val fileTree: FileTreeWalk = input.walk()
        val files = fileTree.maxDepth(maxDepth) //目录层次为maxDepth，1为不检查子目录
            .filter {
                it.isHidden.not() && it.isFile
            }
            .filter { file ->
                //只挑选限制文件夹
                mExcludeDirs.none { eDir ->
                    file.path.contains(eDir, ignoreCase = true)
                }
            }
            .filter {
                //扩展限制
                mIncludeFiles.contains(it.extension)
            }
            .toList()

        message.invoke("prepare content files[${files.size}]")

        val dropCount = files.size - maxFiles
        val contentFiles = if (dropCount > 0) {
            files.drop(dropCount)
        } else {
            files
        }

        message.invoke("read contentFiles[${contentFiles.size}]")

        val cache = File(output, "cache.txt")
        if (cache.exists()) {
            cache.delete()
        }
        cache.setWritable(true)
        cache.createNewFile()

        val fileOutputStream = FileOutputStream(cache, true)
        val writer: OutputStreamWriter = fileOutputStream.writer(CharSet)
        try {
            contentFiles.forEachIndexed { index, file ->

                message.invoke("files[$index] ${file.absolutePath} start.")

                val text = file.readText(CharSet)
                writer.write("\n")
                writer.write(matchContent(text).trimIndent())
                writer.write("\n")
                writer.flush()

                message.invoke("files[$index] ${file.absolutePath} finished.")
            }
        } catch (throwable: Throwable) {
            throwable.printStackTrace()
        } finally {
            try {
                writer.close()
            } catch (throwable: Throwable) {
                throwable.printStackTrace()
            }
        }

        message.invoke("read finished.")

        useResource("template.docx") { inputStream ->

            message.invoke("prepare template.")

            val doc = XWPFDocument(inputStream)
            val runs: List<XWPFRun> = doc.headerList[1].paragraphs[1].runs
            runs[0].setText("$name-copyright", 0)
            runs[1].setText(version, 0)

            message.invoke("start write to template.")

            val scanner = Scanner(FileInputStream(cache), CharSet)
            while (scanner.hasNext()) {
                val line = scanner.nextLine()
                val p1: XWPFParagraph = doc.createParagraph()
                val r1: XWPFRun = p1.createRun()
                r1.fontFamily = "等线 (西文正文)"
                r1.fontSize = 10
                r1.setText(line)
            }
            scanner.close()

            doc.document.body.removeP(0)
            val out = FileOutputStream(File(output, "$name-copyright-$version-source.docx"))
            doc.properties.coreProperties.creator = "Source Copyright Frodo Generator"
            doc.properties.coreProperties.lastModifiedByUser = "haoxiqiang"
            doc.properties.coreProperties.revision = "1"
            doc.properties.coreProperties.setModified(SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Date()))
            doc.write(out)
            out.close()

            message.invoke("save finished.")
        }
    }

    fun matchContent(str: String): String {
        val a = commentRegexA.matcher(str).replaceAll("")
        val b = commentRegexB.matcher(a).replaceAll("")
        return commentRegexC.matcher(b).replaceAll("")
    }
}