import com.thefrodo.copyright.Generator
import org.junit.jupiter.api.Test

internal class GeneratorTest {
    private val content =
        "/Library/Java/JavaVirtualMachines/adoptopenjdk-15.jdk/Contents/Home/bin/java -javaagent:/Users/haoxiqiang/Library/Application Support/JetBrains/Toolbox/apps/IDEA-C/ch-0/212.5457.46/IntelliJ IDEA CE.app/Contents/lib/idea_rt.jar=55645:/Users/haoxiqiang/Library/Application Support/JetBrains/Toolbox/apps/IDEA-C/ch-0/212.5457.46/IntelliJ IDEA CE.app/Contents/bin -Dfile.encoding=UTF-8 -classpath /Users/haoxiqiang/workspace/copyright/build/classes/kotlin/main:/Users/haoxiqiang/workspace/copyright/build/resources/main:/Users/haoxiqiang/.gradle/caches/modules-2/files-2.1/org.jetbrains.kotlin/kotlin-stdlib-jdk8/1.5.21/6b3de2a43405a65502728047db37a98a0c7e72f0/kotlin-stdlib-jdk8-1.5.21.jar:/Users/haoxiqiang/.gradle/caches/modules-2/files-2.1/org.apache.poi/poi-excelant/5.0.0/eda15811a98d6efd67b9d305508fdd38f667e3cd/poi-excelant-5.0.0.jar:/Users/haoxiqiang/.gradle/caches/modules-2/files-2.1/org.apache.poi/poi-ooxml/5.0.0/92e7e4086184ae074c4f1c0da178afed9ab66d1c/poi-ooxml-5.0.0.jar:/Users/haoxiqiang/.gradle/caches/modules-2/files-2.1/org.apache.poi/poi-scratchpad/5.0.0/33d7202a1d5ddd282237cda6d1c4c701f1d9c829/poi-scratchpad-5.0.0.jar:/Users/haoxiqiang/.gradle/caches/modules-2/files-2.1/org.apache.poi/poi/5.0.0/68039007ca335269576dd526e16671c579045dfc/poi-5.0.0.jar:/Users/haoxiqiang/.gradle/caches/modules-2/files-2.1/org.jetbrains.kotlin/kotlin-stdlib-jdk7/1.5.21/f059658740a4b3a3461aba9681457615332bae1c/kotlin-stdlib-jdk7-1.5.21.jar:/Users/haoxiqiang/.gradle/caches/modules-2/files-2.1/org.jetbrains.kotlin/kotlin-stdlib/1.5.21/2f537cad7e9eeb9da73738c8812e1e4cf9b62e4e/kotlin-stdlib-1.5.21.jar:/Users/haoxiqiang/.gradle/caches/modules-2/files-2.1/org.apache.ant/ant/1.10.9/a8a0c9bc4473acdac25832d0a9da2ca9fd9cd35f/ant-1.10.9.jar:/Users/haoxiqiang/.gradle/caches/modules-2/files-2.1/org.apache.santuario/xmlsec/2.2.1/d64462dd9f37f49b311b67b48f2e2b1fb7fabb82/xmlsec-2.2.1.jar:/Users/haoxiqiang/.gradle/caches/modules-2/files-2.1/org.apache.poi/poi-ooxml-lite/5.0.0/ca2284f09a214feb6bd8b20ecbe4bfc8eaef08c1/poi-ooxml-lite-5.0.0.jar:/Users/haoxiqiang/.gradle/caches/modules-2/files-2.1/org.apache.commons/commons-compress/1.20/b8df472b31e1f17c232d2ad78ceb1c84e00c641b/commons-compress-1.20.jar:/Users/haoxiqiang/.gradle/caches/modules-2/files-2.1/com.github.virtuald/curvesapi/1.06/159dd2e8956459a4eb0a9a6ecda9004d8d289708/curvesapi-1.06.jar:/Users/haoxiqiang/.gradle/caches/modules-2/files-2.1/org.bouncycastle/bcpkix-jdk15on/1.68/81da950604ff0b2652348cbd2b48fde46ced9867/bcpkix-jdk15on-1.68.jar:/Users/haoxiqiang/.gradle/caches/modules-2/files-2.1/org.bouncycastle/bcprov-jdk15on/1.68/46a080368d38b428d237a59458f9bc915222894d/bcprov-jdk15on-1.68.jar:/Users/haoxiqiang/.gradle/caches/modules-2/files-2.1/org.apache.xmlgraphics/batik-all/1.13/b2b05df4bbe65d2bedb5f675d8eaa490a7577a03/batik-all-1.13.jar:/Users/haoxiqiang/.gradle/caches/modules-2/files-2.1/de.rototor.pdfbox/graphics2d/0.30/e34a2638d08357e206a9df58fdc90d7c8eec4600/graphics2d-0.30.jar:/Users/haoxiqiang/.gradle/caches/modules-2/files-2.1/org.slf4j/jcl-over-slf4j/1.7.30/cd92524ea19d27e5b94ecd251e1af729cffdfe15/jcl-over-slf4j-1.7.30.jar:/Users/haoxiqiang/.gradle/caches/modules-2/files-2.1/org.slf4j/slf4j-api/1.7.30/b5a4b6d16ab13e34a88fae84c35cd5d68cac922c/slf4j-api-1.7.30.jar:/Users/haoxiqiang/.gradle/caches/modules-2/files-2.1/commons-codec/commons-codec/1.15/49d94806b6e3dc933dacbd8acb0fdbab8ebd1e5d/commons-codec-1.15.jar:/Users/haoxiqiang/.gradle/caches/modules-2/files-2.1/org.apache.commons/commons-collections4/4.4/62ebe7544cb7164d87e0637a2a6a2bdc981395e8/commons-collections4-4.4.jar:/Users/haoxiqiang/.gradle/caches/modules-2/files-2.1/org.apache.commons/commons-math3/3.6.1/e4ba98f1d4b3c80ec46392f25e094a6a2e58fcbf/commons-math3-3.6.1.jar:/Users/haoxiqiang/.gradle/caches/modules-2/files-2.1/com.zaxxer/SparseBitSet/1.2/8467c813d442837fcaeddbc42cf5c5359fab4933/SparseBitSet-1.2.jar:/Users/haoxiqiang/.gradle/caches/modules-2/files-2.1/org.jetbrains.compose.desktop/desktop-jvm/1.0.0-alpha3/7d2ec16f4e057de47d41ffc5c8416f9f85aeab3e/desktop-jvm-1.0.0-alpha3.jar:/Users/haoxiqiang/.gradle/caches/modules-2/files-2.1/org.jetbrains/annotations/13.0/919f0dfe192fb4e063e7dacadee7f8bb9a2672a9/annotations-13.0.jar:/Users/haoxiqiang/.gradle/caches/modules-2/files-2.1/org.jetbrains.kotlin/kotlin-stdlib-common/1.5.21/cc8bf3586fd2ebcf234058b9440bb406e62dfacb/kotlin-stdlib-common-1.5.21.jar:/Users/haoxiqiang/.gradle/caches/modules-2/files-2.1/org.apache.ant/ant-launcher/1.10.9/bcc582424a533933d9960b7a4ccde12c6f257245/ant-launcher-1.10.9.jar:/Users/haoxiqiang/.gradle/caches/modules-2/files-2.1/org.apache.xmlbeans/xmlbeans/4.0.0/b4d6063550992edd2bbdf7b278ff0a15e78e16d/xmlbeans-4.0.0.jar:/Users/haoxiqiang/.gradle/caches/modules-2/files-2.1/org.apache.xmlgraphics/batik-rasterizer-ext/1.13/451de768d33a76f74c50492412ffa46ff30c58aa/batik-rasterizer-ext-1.13.jar:/Users/haoxiqiang/.gradle/caches/modules-2/files-2.1/org.apache.xmlgraphics/batik-rasterizer/1.13/2377ed2b69069bd5c53a52eb055108667b4183e/batik-rasterizer-1.13.jar:/Users/haoxiqiang/.gradle/caches/modules-2/files-2.1/org.apache.xmlgraphics/batik-svgrasterizer/1.13/b4892e196ec5d829478f22c3a8d9c2321c2daa40/batik-svgrasterizer-1.13.jar:/Users/haoxiqiang/.gradle/caches/modules-2/files-2.1/org.apache.xmlgraphics/batik-codec/1.13/635aa7b508dd7ab1bc2c4bec61e5e87d96a87f12/batik-codec-1.13.jar:/Users/haoxiqiang/.gradle/caches/modules-2/files-2.1/org.apache.xmlgraphics/batik-squiggle-ext/1.13/234c427f67925208012894f7195b80a066440c5f/batik-squiggle-ext-1.13.jar:/Users/haoxiqiang/.gradle/caches/modules-2/files-2.1/org.apache.xmlgraphics/batik-extension/1.13/92f42a0cbda28d920116bb0648d2d2eecabdd19/batik-extension-1.13.jar:/Users/haoxiqiang/.gradle/caches/modules-2/files-2.1/org.apache.xmlgraphics/batik-slideshow/1.13/4d6ada95bcd8173f6df31a5ed85ecc84f33fb580/batik-slideshow-1.13.jar:/Users/haoxiqiang/.gradle/caches/modules-2/files-2.1/org.apache.xmlgraphics/batik-squiggle/1.13/ea736a9768c4e9b842023e2107a965870dccbdd7/batik-squiggle-1.13.jar:/Users/haoxiqiang/.gradle/caches/modules-2/files-2.1/org.apache.xmlgraphics/batik-svgbrowser/1.13/279a07410db28fdb3d819c148fe8fb7e10ee10a7/batik-svgbrowser-1.13.jar:/Users/haoxiqiang/.gradle/caches/modules-2/files-2.1/org.apache.xmlgraphics/batik-swing/1.13/232653b04333483431cce9cdece2978fc6577c27/batik-swing-1.13.jar:/Users/haoxiqiang/.gradle/caches/modules-2/files-2.1/org.apache.xmlgraphics/batik-svgpp/1.13/255118c63cc93ccfddc40a4472acab789f142d6a/batik-svgpp-1.13.jar:/Users/haoxiqiang/.gradle/caches/modules-2/files-2.1/org.apache.xmlgraphics/batik-transcoder/1.13/c315cbb6cc7a809c18995ae84f37c087b6f71fb3/batik-transcoder-1.13.jar:/Users/haoxiqiang/.gradle/caches/modules-2/files-2.1/org.apache.xmlgraphics/batik-bridge/1.13/fe5e35b253b859e6a0a67fe3595bc8c3ad6faa52/batik-bridge-1.13.jar:/Users/haoxiqiang/.gradle/caches/modules-2/files-2.1/org.apache.xmlgraphics/batik-script/1.13/4579ef2a459f3574bd85236892c6af9c4d821ef0/batik-script-1.13.jar:/Users/haoxiqiang/.gradle/caches/modules-2/files-2.1/org.apache.xmlgraphics/batik-anim/1.13/a5d06a4fbaf9cf2015c76d95d9a5dcf3a5bcf9e2/batik-anim-1.13.jar:/Users/haoxiqiang/.gradle/caches/modules-2/files-2.1/org.apache.xmlgraphics/batik-gvt/1.13/e324b1b5bb23649c67579b8c2ee45f33de42e539/batik-gvt-1.13.jar:/Users/haoxiqiang/.gradle/caches/modules-2/files-2.1/org.apache.xmlgraphics/batik-svg-dom/1.13/ad16f601df77e9230a5a6a78ec7bfaf3ee2767d4/batik-svg-dom-1.13.jar:/Users/haoxiqiang/.gradle/caches/modules-2/files-2.1/org.apache.xmlgraphics/batik-parser/1.13/33169dfb1155b76705b8640a1aa9a222564b3a62/batik-parser-1.13.jar:/Users/haoxiqiang/.gradle/caches/modules-2/files-2.1/org.apache.xmlgraphics/batik-ttf2svg/1.13/70d2b5b9b2f253d6a89e208e7bb8d9658ac61f46/batik-ttf2svg-1.13.jar:/Users/haoxiqiang/.gradle/caches/modules-2/files-2.1/org.apache.xmlgraphics/batik-svggen/1.13/aee02c61f8ed1a50db182a1974f0ef11166fcc01/batik-svggen-1.13.jar:/Users/haoxiqiang/.gradle/caches/modules-2/files-2.1/org.apache.xmlgraphics/batik-awt-util/1.13/d6dca71c2e3e48901a5a3cab9477f0b7a7c53c8/batik-awt-util-1.13.jar:/Users/haoxiqiang/.gradle/caches/modules-2/files-2.1/org.apache.xmlgraphics/batik-dom/1.13/818605a4cffadb5ec0db39b2f560c2206d65f691/batik-dom-1.13.jar:/Users/haoxiqiang/.gradle/caches/modules-2/files-2.1/org.apache.xmlgraphics/batik-css/1.13/90d83f11998260ad0f7ac784f90181f41ccd5bcd/batik-css-1.13.jar:/Users/haoxiqiang/.gradle/caches/modules-2/files-2.1/org.apache.xmlgraphics/batik-gui-util/1.13/a74a998205a316ff1ab2cab5240c9973de5fda69/batik-gui-util-1.13.jar:/Users/haoxiqiang/.gradle/caches/modules-2/files-2.1/org.apache.xmlgraphics/batik-xml/1.13/1384efa56d6047a6d87e955a3a81a8e85061a74d/batik-xml-1.13.jar:/Users/haoxiqiang/.gradle/caches/modules-2/files-2.1/org.apache.xmlgraphics/batik-util/1.13/341818ceb5f7088c9ff5b35fac419ad9a74d8b6f/batik-util-1.13.jar:/Users/haoxiqiang/.gradle/caches/modules-2/files-2.1/org.apache.xmlgraphics/batik-constants/1.13/2778851f7c8e7023578e7b76c4e4f11e4b183a13/batik-constants-1.13.jar:/Users/haoxiqiang/.gradle/caches/modules-2/files-2.1/org.apache.xmlgraphics/batik-ext/1.13/ea55108b070051c5440613cfbbe91414010d183e/batik-ext-1.13.jar:/Users/haoxiqiang/.gradle/caches/modules-2/files-2.1/org.apache.xmlgraphics/batik-i18n/1.13/e08aab4a78a5825144d7f1772356c0ee059a8d46/batik-i18n-1.13.jar:/Users/haoxiqiang/.gradle/caches/modules-2/files-2.1/org.apache.pdfbox/pdfbox/2.0.22/61f19d1ebc0bec25bbbc0eb2b28ee872a39a76b3/pdfbox-2.0.22.jar:/Users/haoxiqiang/.gradle/caches/modules-2/files-2.1/org.apache.xmlgraphics/batik-shared-resources/1.13/5b886d1a3327b1bf09e377d359c5d2392cccfed0/batik-shared-resources-1.13.jar:/Users/haoxiqiang/.gradle/caches/modules-2/files-2.1/xml-apis/xml-apis-ext/1.3.04/41a8b86b358e87f3f13cf46069721719105aff66/xml-apis-ext-1.3.04.jar:/Users/haoxiqiang/.gradle/caches/modules-2/files-2.1/org.apache.xmlgraphics/xmlgraphics-commons/2.4/8d261df049a23d40a053d2700399ea76080fe0a8/xmlgraphics-commons-2.4.jar:/Users/haoxiqiang/.gradle/caches/modules-2/files-2.1/xalan/xalan/2.7.2/d55d3f02a56ec4c25695fe67e1334ff8c2ecea23/xalan-2.7.2.jar:/Users/haoxiqiang/.gradle/caches/modules-2/files-2.1/xml-apis/xml-apis/1.4.01/3789d9fada2d3d458c4ba2de349d48780f381ee3/xml-apis-1.4.01.jar:/Users/haoxiqiang/.gradle/caches/modules-2/files-2.1/org.apache.pdfbox/fontbox/2.0.22/8b1db262fa6b79cde6d1c8e976a530b960820ae3/fontbox-2.0.22.jar:/Users/haoxiqiang/.gradle/caches/modules-2/files-2.1/org.jetbrains.compose.material/material-desktop/1.0.0-alpha3/60d4a46d2ee31e82ab61342887203b23aee0ba83/material-desktop-1.0.0-alpha3.jar:/Users/haoxiqiang/.gradle/caches/modules-2/files-2.1/org.jetbrains.compose.foundation/foundation-desktop/1.0.0-alpha3/29c590b69d13ec16352497848d1bf05da1de062e/foundation-desktop-1.0.0-alpha3.jar:/Users/haoxiqiang/.gradle/caches/modules-2/files-2.1/org.jetbrains.compose.ui/ui-desktop/1.0.0-alpha3/7f33f2592490b6d23494c0842d6f15ac592f9bb7/ui-desktop-1.0.0-alpha3.jar:/Users/haoxiqiang/.gradle/caches/modules-2/files-2.1/org.jetbrains.compose.ui/ui-tooling-preview-desktop/1.0.0-alpha3/4676c56ea7defd68facfab054079ac1e76aba57f/ui-tooling-preview-desktop-1.0.0-alpha3.jar:/Users/haoxiqiang/.gradle/caches/modules-2/files-2.1/org.jetbrains.compose.runtime/runtime-desktop/1.0.0-alpha3/481c6e0d45e192d4f02f993e049262e0668f6018/runtime-desktop-1.0.0-alpha3.jar:/Users/haoxiqiang/.gradle/caches/modules-2/files-2.1/commons-io/commons-io/1.3.1/b90b6ac57cf27a2858eaa490d02ba7945d18ca7b/commons-io-1.3.1.jar:/Users/haoxiqiang/.gradle/caches/modules-2/files-2.1/xalan/serializer/2.7.2/24247f3bb052ee068971393bdb83e04512bb1c3c/serializer-2.7.2.jar:/Users/haoxiqiang/.gradle/caches/modules-2/files-2.1/org.jetbrains.kotlinx/kotlinx-coroutines-swing/1.5.0/f9702179f0e36a0541ffe77a7a62596c4fc6ad83/kotlinx-coroutines-swing-1.5.0.jar:/Users/haoxiqiang/.gradle/caches/modules-2/files-2.1/androidx.annotation/annotation/1.2.0/57136ff68ee784c6e19db34ed4a175338fadfde1/annotation-1.2.0.jar:/Users/haoxiqiang/.gradle/caches/modules-2/files-2.1/org.jetbrains.compose.material/material-ripple-desktop/1.0.0-alpha3/ffc54fa1f9c6e164d6ccdd53f7411bd80ccbce6c/material-ripple-desktop-1.0.0-alpha3.jar:/Users/haoxiqiang/.gradle/caches/modules-2/files-2.1/org.jetbrains.compose.material/material-icons-core-desktop/1.0.0-alpha3/3e869bc14a82c27647e3719579d6acb517d2fc2a/material-icons-core-desktop-1.0.0-alpha3.jar:/Users/haoxiqiang/.gradle/caches/modules-2/files-2.1/org.jetbrains.compose.animation/animation-core-desktop/1.0.0-alpha3/ec648418e6980b80f376f2b0455d5e2ba74f0445/animation-core-desktop-1.0.0-alpha3.jar:/Users/haoxiqiang/.gradle/caches/modules-2/files-2.1/org.jetbrains.compose.ui/ui-text-desktop/1.0.0-alpha3/c1706e1e249c65fe08a672f3ab8f442ee864cf59/ui-text-desktop-1.0.0-alpha3.jar:/Users/haoxiqiang/.gradle/caches/modules-2/files-2.1/org.jetbrains.compose.animation/animation-desktop/1.0.0-alpha3/eeff15e8d42d2fab8e6fb4eb0356ae397070aa49/animation-desktop-1.0.0-alpha3.jar:/Users/haoxiqiang/.gradle/caches/modules-2/files-2.1/org.jetbrains.compose.runtime/runtime-saveable-desktop/1.0.0-alpha3/1b7a4801b28b5541d87cd9ae560571a77cc94dd/runtime-saveable-desktop-1.0.0-alpha3.jar:/Users/haoxiqiang/.gradle/caches/modules-2/files-2.1/org.jetbrains.compose.ui/ui-graphics-desktop/1.0.0-alpha3/f3b1bfc01b7316e6d5af522b1025fe09f7fff137/ui-graphics-desktop-1.0.0-alpha3.jar:/Users/haoxiqiang/.gradle/caches/modules-2/files-2.1/org.jetbrains.compose.ui/ui-unit-desktop/1.0.0-alpha3/5cefe80c330e154436abdb12825a828229ed950f/ui-unit-desktop-1.0.0-alpha3.jar:/Users/haoxiqiang/.gradle/caches/modules-2/files-2.1/org.jetbrains.compose.ui/ui-geometry-desktop/1.0.0-alpha3/261a169b4e2816397d8c4e22e63a2d590f99210a/ui-geometry-desktop-1.0.0-alpha3.jar:/Users/haoxiqiang/.gradle/caches/modules-2/files-2.1/org.jetbrains.kotlinx/kotlinx-coroutines-core-jvm/1.5.0/d8cebccdcddd029022aa8646a5a953ff88b13ac8/kotlinx-coroutines-core-jvm-1.5.0.jar:/Users/haoxiqiang/.gradle/caches/modules-2/files-2.1/org.jetbrains.skiko/skiko-jvm/0.3.9/8b3108a3fb80baa30163d20d8176f108d895b44f/skiko-jvm-0.3.9.jar:/Users/haoxiqiang/.gradle/caches/modules-2/files-2.1/org.jetbrains.compose.foundation/foundation-layout-desktop/1.0.0-alpha3/878f19bd721b99f677e959d96595573f8198eb1c/foundation-layout-desktop-1.0.0-alpha3.jar:/Users/haoxiqiang/.gradle/caches/modules-2/files-2.1/org.jetbrains.skiko/skiko-jvm-runtime-macos-x64/0.3.9/7dd5c3ab33897ea23d4e46251a7d04515755d0dd/skiko-jvm-runtime-macos-x64-0.3.9.jar:/Users/haoxiqiang/.gradle/caches/modules-2/files-2.1/com.fasterxml.woodstox/woodstox-core/5.2.1/2262f79ba939a9cd827e5a0f0fd1b507fcacce57/woodstox-core-5.2.1.jar:/Users/haoxiqiang/.gradle/caches/modules-2/files-2.1/org.codehaus.woodstox/stax2-api/4.2/13c2b30926bca0429c704c4b4ca0b5d0432b69cd/stax2-api-4.2.jar:/Users/haoxiqiang/.gradle/caches/modules-2/files-2.1/org.jetbrains.compose.ui/ui-util-desktop/1.0.0-alpha3/6de31edde97babd7339e67bb1b82ebff1a805e9c/ui-util-desktop-1.0.0-alpha3.jar MainKt\n" +
                "\timport org.apache.poi.xwpf.usermodel.XWPFDocument\n" +
                "import org.apache.poi.xwpf.usermodel.XWPFParagraph\n" +
                "import org.apache.poi.xwpf.usermodel.XWPFRun\n" +
                "import java.io.File\n" +
                "import java.io.FileInputStream\n" +
                "import java.io.FileOutputStream\n" +
                "import java.text.SimpleDateFormat\n" +
                "import java.util.*\n" +
                "\n" +
                "object com.thefrodo.copyright.Generator {\n" +
                "\n" +
                "    private const val version = \"v1.0.0\"\n" +
                "\n" +
                "    private val mIncludeFiles = arrayOf(\"kt\", \"java\", \"swift\", \"cc\")\n" +
                "    private val mExcludeDirs = arrayOf(\".idea\", \"test\", \"gradle\", \".git\", \"build\", \".gradle\")\n" +
                "\n" +
                "    fun doGenerator(input: File, output: File, docName: String, maxDepth: Int = 10) {\n" +
                "\n" +
                "\n" +
                "        val fileTree: FileTreeWalk = input.walk()\n" +
                "        val files = fileTree.maxDepth(maxDepth) //目录层次为maxDepth，1为不检查子目录\n" +
                "            .filter {\n" +
                "                it.isHidden.not() && it.isFile\n" +
                "            }\n" +
                "            .filter { file ->\n" +
                "                //只挑选限制文件夹\n" +
                "                mExcludeDirs.none { eDir -> file.path.contains(eDir) }\n" +
                "            }\n" +
                "            .filter {\n" +
                "                //扩展限制\n" +
                "                mIncludeFiles.contains(it.extension)\n" +
                "            }\n" +
                "            .toList()\n" +
                "\n" +
                "        val contentBuilder: StringBuilder = StringBuilder()\n" +
                "        contentBuilder.append(\"\\n\").append(\"\\t\")\n" +
                "        for (file in files) {\n" +
                "            val scanner = Scanner(FileInputStream(file), \"UTF-8\")\n" +
                "            while (scanner.hasNext()) {\n" +
                "                contentBuilder.append(scanner.nextLine()).append(\"\\n\")\n" +
                "            }\n" +
                "            scanner.close()\n" +
                "        }\n" +
                "        var s = contentBuilder.toString().trimIndent()\n" +
                "        println(s)\n" +
                "\n" +
                "        s = s.replace(\"(?<!:)\\\\/\\\\/.*\".toRegex(), \"\") //删除“//”注释\n" +
                "        s = s.replace(\"\\\\/\\\\*(\\\\s|.)*?\\\\*\\\\/\".toRegex(), \"\") //删除“/**/”注释\n" +
                "        s = s.replace(\"(?m)^\\\\s*\$(\\\\n|\\\\r\\\\n)\".toRegex(), \"\") //删除空行\n" +
                "\n" +
                "        val doc = XWPFDocument(this::class.java.getResourceAsStream(\"template.docx\"))\n" +
                "        val runs: List<XWPFRun> = doc.headerList[1].paragraphs[1].runs\n" +
                "        runs[0].setText(docName, 0)\n" +
                "        runs[1].setText(version, 0)\n" +
                "        var scanner = Scanner(s)\n" +
                "        var total = 0\n" +
                "        while (scanner.hasNext()) {\n" +
                "            total++\n" +
                "            scanner.nextLine()\n" +
                "        }\n" +
                "        println(\"总计：\" + total + \"行\")\n" +
                "        scanner = Scanner(s)\n" +
                "        while (scanner.hasNext()) {\n" +
                "            val p1: XWPFParagraph = doc.createParagraph()\n" +
                "            val r1: XWPFRun = p1.createRun()\n" +
                "            r1.fontFamily = \"等线 (西文正文)\"\n" +
                "            r1.fontSize = 10\n" +
                "            r1.setText(scanner.nextLine())\n" +
                "        }\n" +
                "        scanner.close()\n" +
                "        doc.document.body.removeP(0)\n" +
                "        val out = FileOutputStream(File(output, docName + version + \"源代码.docx\"))\n" +
                "        doc.properties.coreProperties.creator = \"软件著作权代码文档生成器\"\n" +
                "        doc.properties.coreProperties.lastModifiedByUser = \"软件著作权代码文档生成器\"\n" +
                "        doc.properties.coreProperties.revision = \"1\"\n" +
                "        doc.properties.coreProperties.setModified(SimpleDateFormat(\"yyyy-MM-dd HH:mm:ss\").format(Date()))\n" +
                "        doc.write(out)\n" +
                "        out.close()\n" +
                "    }\n" +
                "}\n" +
                "// Copyright 2000-2021 JetBrains s.r.o. and contributors. Use of this source code is governed by the Apache 2.0 license that can be found in the LICENSE file.\n" +
                "import androidx.compose.desktop.DesktopMaterialTheme\n" +
                "import androidx.compose.desktop.ui.tooling.preview.Preview\n" +
                "import androidx.compose.material.Button\n" +
                "import androidx.compose.material.Text\n" +
                "import androidx.compose.runtime.Composable\n" +
                "import androidx.compose.runtime.getValue\n" +
                "import androidx.compose.runtime.mutableStateOf\n" +
                "import androidx.compose.runtime.remember\n" +
                "import androidx.compose.runtime.setValue\n" +
                "import androidx.compose.ui.window.Window\n" +
                "import androidx.compose.ui.window.application\n" +
                "import java.io.File\n" +
                "\n" +
                "@Composable\n" +
                "@Preview\n" +
                "fun App() {\n" +
                "    var text by remember { mutableStateOf(\"Hello, World!\") }\n" +
                "\n" +
                "    DesktopMaterialTheme {\n" +
                "        Button(onClick = {\n" +
                "            text = \"Hello, Desktop!\"\n" +
                "            val input = File(\"/Users/haoxiqiang/workspace/copyright\")\n" +
                "            val output = File(\"/Users/haoxiqiang/workspace/copyright\")\n" +
                "            com.thefrodo.copyright.Generator.doGenerator(input, output, \"Copyright\")\n" +
                "        }) {\n" +
                "            Text(text)\n" +
                "        }\n" +
                "    }\n" +
                "}\n" +
                "\n" +
                "       /**\n" +
                "                 * replace all comment infomation\n" +
                "                 */\n" +
                "                /**\n" +
                "                 * 中文\n" +
                "                 */" + "\nfun main() = application {\n" +
                "    Window(onCloseRequest = ::exitApplication) {\n" +
                "        App()\n" +
                "    }\n" +
                "}\n" +
                "总计：101行\n"

    @Test
    fun matchContent() {
        println(Generator.matchContent(content))
    }
}