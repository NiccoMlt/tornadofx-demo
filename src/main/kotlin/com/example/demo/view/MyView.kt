package com.example.demo.view

import javafx.collections.FXCollections
import javafx.collections.ObservableList
import tornadofx.Controller
import tornadofx.View
import tornadofx.label
import tornadofx.listview
import tornadofx.vbox

class MyView : View() {
    val controller: MyController by inject()

    override val root = vbox {
        label("My items")
        listview(controller.values)
    }
}

class MyController : Controller() {
    val values: ObservableList<String> = FXCollections.observableArrayList("Alpha", "Beta", "Gamma", "Delta")
}
