package com.thefrodo.copyright

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import java.awt.Color
import java.awt.GridBagLayout
import java.awt.Window
import java.awt.geom.RoundRectangle2D
import javax.swing.BorderFactory
import javax.swing.JDialog
import javax.swing.JLabel
import javax.swing.JPanel

class ToastMessage(private val window: Window) : JDialog() {

    private val milliseconds = 1500

    companion object {
        private const val serialVersionUID = 1L
        private var spamProtect = false
    }

    fun show(msg: String) {
        GlobalScope.launch(Dispatchers.Main) {
            if (spamProtect) {
                return@launch
            }
            isUndecorated = true
            isAlwaysOnTop = true
            focusableWindowState = false
            layout = GridBagLayout()

            val panel = JPanel()
            panel.border = BorderFactory.createEmptyBorder(5, 10, 5, 10)
            panel.background = Color(160, 160, 160)
            val toastLabel = JLabel(msg)
            toastLabel.foreground = Color.WHITE
            panel.add(toastLabel)
            add(panel)
            pack()
            val xCoordinate = window.locationOnScreen.x + window.width / 2 - width / 2
            val yCoordinate = window.locationOnScreen.y + (window.height.toDouble() * 0.75).toInt() - height / 2
            setLocation(xCoordinate, yCoordinate)
            shape = RoundRectangle2D.Double(0.0, 0.0, width.toDouble(), height.toDouble(), 30.0, 30.0)
            isVisible = true

            try {
                spamProtect = true
                delay(milliseconds.toLong())
                dispose()
                spamProtect = false
            } catch (e: InterruptedException) {
                e.printStackTrace()
            }
        }
    }
}