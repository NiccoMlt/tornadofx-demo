package com.example.demo.view

import javafx.beans.property.SimpleStringProperty
import tornadofx.Controller
import tornadofx.View
import tornadofx.action
import tornadofx.button
import tornadofx.field
import tornadofx.fieldset
import tornadofx.form
import tornadofx.textfield

class MinimalControllerView : View() {
    val controller: MyController by inject()
    val input = SimpleStringProperty()

    override val root = form {
        fieldset {
            field("Input") {
                textfield(input)
            }

            button("Commit") {
                action {
                    controller.writeToDb(input.value)
                    input.value = ""
                }
            }
        }
    }

    companion object {
        class MyController : Controller() {
            fun writeToDb(inputValue: String) {
                println("Writing $inputValue to database!")
            }
        }
    }
}