package com.example.demo.view

import tornadofx.Fragment
import tornadofx.View
import tornadofx.action
import tornadofx.button
import tornadofx.label
import tornadofx.vbox

class MyView : View() {
    override val root = vbox {
        button("Press Me") {
            action {
                // While openModal opens in a new Stage, openInternalWindow opens over the current root node,
                // or any other node if you specify it
                openInternalWindow<MyFragment>()
                /*
                 * Optional Arguments for openInternalWindow()
                 * view	                -> UIComponent  -> The component will be the content of the new window
                 * view                 -> KClass       -> Alternatively, the class of the view instead of an instance
                 * icon                 -> Node         -> Optional window icon
                 * scope                -> Scope        -> If you specify the view class, you can also specify the scope
                 * modal                -> Boolean      -> If the node should be disabled while the window is active
                 * escapeClosesWindow   -> Boolean      -> Sets the ESC key to call close(). Default: true
                 * owner                -> Node         -> Specify the owner Node for this window
                 */
            }
        }
    }
}

/** A Fragment is a special type of View designed to have multiple instances */
class MyFragment : Fragment() {
    override val root = label("This is a popup")
}