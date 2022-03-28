import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.awt.ComposeWindow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import com.thefrodo.copyright.Generator
import com.thefrodo.copyright.ToastMessage
import com.thefrodo.copyright.getDirectory
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import java.io.File

@Composable
@Preview
fun App(window: ComposeWindow) {

    var inputDir by remember { mutableStateOf("") }
    var outputDir by remember { mutableStateOf("") }
    var console by remember { mutableStateOf("console prepare:") }

    MaterialTheme {
        Column(
            modifier = Modifier.fillMaxSize()
                .background(color = Color(0xFFF2F2F2))
                .padding(Dp(16.0f)),
            verticalArrangement = Arrangement.spacedBy(
                Dp(16.0f)
            ),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Row(
                Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(Dp(16.0f)),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Button(
                    modifier = Modifier.width(Dp(160.0f))
                        .background(color = Color(0xFFF2F2F2))
                        .padding(Dp(8.0f)),
                    onClick = {
                        val directory = window.getDirectory()
                        println(directory?.absolutePath)
                        inputDir = directory?.absolutePath ?: ""
                    }
                ) {
                    Text("源代码路径")
                }
                Text(inputDir)
            }
            Row(
                Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(Dp(16.0f)),
                verticalAlignment = Alignment.CenterVertically
            ) {
            }

            Row(
                Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(Dp(16.0f)),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Button(
                    modifier = Modifier.width(Dp(160.0f))
                        .background(color = Color(0xFFF2F2F2))
                        .padding(Dp(8.0f)),
                    onClick = {
                        //text = "Hello, Desktop!"
                        val directory = window.getDirectory()
                        println(directory?.absolutePath)
                        outputDir = directory?.absolutePath ?: ""
                    }
                ) {
                    Text(" 文档路径 ")
                }
                Text(outputDir)
            }

            Box {
                Button(
                    modifier = Modifier.width(Dp(160.0f))
                        .background(color = Color(0xFFF2F2F2))
                        .padding(Dp(8.0f)),
                    onClick = {
                        if (inputDir.isEmpty()) {
                            ToastMessage(window).show("必须选择输入路径")
                            return@Button
                        }
                        if (outputDir.isEmpty()) {
                            ToastMessage(window).show("必须选择输出路径")
                            return@Button
                        }
                        val input = File(inputDir)
                        val output = File(outputDir)

                        GlobalScope.launch(Dispatchers.IO) {
                            Generator.doGenerator(input, output, maxDepth = 18) {
                                launch(Dispatchers.Main) {
                                    println(it)
                                    console = it
                                }
                            }
                            ToastMessage(window).show("Ok!")
                        }
                    }
                ) {
                    Text(" 生成 ")
                }
            }

            Row {
                Text(console)
            }
        }
    }
}

fun main() = application {
    Window(
        title = "Software Capture",
        icon = painterResource("ic_launcher.png"),
        onCloseRequest = ::exitApplication
    ) {
        App(this.window)
    }
}
