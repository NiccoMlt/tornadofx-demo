package com.example.demo.view

import javafx.beans.property.SimpleStringProperty
import tornadofx.Controller
import tornadofx.View
import tornadofx.action
import tornadofx.button
import tornadofx.fieldset
import tornadofx.form
import tornadofx.textfield

class MyView : View() {
    val controller: MyController by inject()
    val input = SimpleStringProperty()

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
}

class MyController : Controller() {
    fun loadText() = "Pippo"
}

