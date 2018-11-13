package com.example.demo.view

import tornadofx.View
import tornadofx.borderpane
import tornadofx.label

class InjectingMasterView : View() {

    // Explicitly retrieve TopView
    // The find() function will retrieve a singleton instance of a View or other components
    val topView = find(TopView::class)

    // Create a lazy reference to BottomView
    // The inject() delegate will lazily assign a given component to a property
    val bottomView: BottomView by inject()

    // You can use either find() or inject(), but using inject() delegates:
    // - is the most idiomatic means to perform dependency injection
    // - has the advantage of lazy loading.

    override val root = borderpane {
        top = topView.root
        bottom = bottomView.root
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
