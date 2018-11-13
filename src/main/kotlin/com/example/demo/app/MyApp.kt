package com.example.demo.app

import com.example.demo.view.MyView
import tornadofx.App
import tornadofx.launch

class MyApp : App(MyView::class)


/** Package level main function for compatibility purpose.*/
// This main function would be compiled to com.example.app.MyAppKt
fun main(args: Array<String>) {
    launch<MyApp>(args)
}