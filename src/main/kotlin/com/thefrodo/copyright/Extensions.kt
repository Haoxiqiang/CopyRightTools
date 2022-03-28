package com.thefrodo.copyright

import java.awt.FileDialog
import java.io.File
import javax.swing.JFileChooser
import javax.swing.JFrame


fun JFrame.getDirectory(): File? {
    return if (System.getProperty("os.name").contains("Mac")) {
        System.setProperty("apple.awt.fileDialogForDirectories", "true")
        val dialog = FileDialog(this, "Choose destination", FileDialog.LOAD)
        dialog.isMultipleMode = false
        dialog.isVisible = true
        val name: String? = dialog.file
        val dir: String? = dialog.directory
        if (name == null || dir == null) {
            null
        } else {
            File(dialog.directory, dialog.file)
        }
    } else {
        val chooser = JFileChooser()
        chooser.fileSelectionMode = JFileChooser.DIRECTORIES_ONLY
        chooser.dialogTitle = "Choose destination"
        val result = chooser.showOpenDialog(null)
        if (result == JFileChooser.APPROVE_OPTION) {
            val dir = chooser.selectedFile ?: return null
            if (dir.absolutePath.trim { it <= ' ' }.isEmpty()) {
                null
            } else {
                dir
            }
        } else {
            null
        }
    }
}
