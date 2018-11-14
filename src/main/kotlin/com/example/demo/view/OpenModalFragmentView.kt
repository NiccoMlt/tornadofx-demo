package com.example.demo.view

import javafx.stage.StageStyle
import tornadofx.Fragment
import tornadofx.View
import tornadofx.action
import tornadofx.button
import tornadofx.label
import tornadofx.vbox

class OpenModalFragmentView : View() {
    override val root = vbox {
        button("Press Me") {
            action {
                // Both View and Fragment support openModal(), openWindow(), and openInternalWindow() functions
                // that will open the root node in a separate Window
                find<MyFragment>().openModal(stageStyle = StageStyle.UTILITY)
                /*
                 * Optional Arguments for openModal():
                 * stageStyle           -> StageStyle   -> Defines one of the possible enum styles for Stage
                 * modality             -> Modality     -> Defines one of the possible enum modality types for Stage
                 * escapeClosesWindow   -> Boolean      -> Sets the ESC key to call close(). Default: true
                 * owner                -> Window       -> Specify the owner Window for this Stage
                 * block                -> Boolean      -> Block UI execution until the Window closes. Default: false
                 */
            }
        }
    }


    companion object {
        /** A Fragment is a special type of View designed to have multiple instances */
        class MyFragment: Fragment() {
            override val root = label("This is a popup")
        }
    }
}