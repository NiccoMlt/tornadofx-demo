package com.example.demo.view

import javafx.beans.property.SimpleStringProperty
import tornadofx.Controller
import tornadofx.View
import tornadofx.action
import tornadofx.button
import tornadofx.fieldset
import tornadofx.form
import tornadofx.textfield

class LongRunningTaskView : View() {
    val controller: MyController by inject()

    override val root = form {
        fieldset {
            val textfield = textfield()
            button("Update text") {
                action {
                    runAsync {
                        controller.loadText()
                    } ui { loadedText ->
                        textfield.text = loadedText
                    }
                }
            }

        }
    }

    companion object {
        class MyController : Controller() {
            fun loadText() = "Pippo"
        }
    }
}

