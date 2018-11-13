package com.example.demo.view

import tornadofx.View
import tornadofx.borderpane
import tornadofx.label

class MasterView: View() {
    override val root = borderpane {
        top<TopView>()
        bottom<BottomView>()
    }

    companion object {
        class TopView: View() {
            override val root = label("Top View")
        }

        class BottomView: View() {
            override val root = label("Bottom View")
        }
    }
}
