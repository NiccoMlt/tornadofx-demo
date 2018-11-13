package com.example.demo.view

import com.example.demo.model.Person
import javafx.scene.paint.Color
import tornadofx.View
import tornadofx.c
import tornadofx.column
import tornadofx.observable
import tornadofx.style
import tornadofx.tableview
import java.time.LocalDate

class PersonView : View() {

    private val persons = listOf(
            Person(1, "Samantha Stuart", LocalDate.of(1981, 12, 4)),
            Person(2, "Tom Marks", LocalDate.of(2001, 1, 23)),
            Person(3, "Stuart Gills", LocalDate.of(1989, 5, 23)),
            Person(3, "Nicole Williams", LocalDate.of(1998, 8, 11))
    ).observable()

    override val root = tableview<Person> {
        items = persons
        column("ID", Person::idProperty)
        column("Name", Person::nameProperty)
        column("Birthday", Person::birthdayProperty)
        column("Age", Person::ageProperty).cellFormat {
            text = it.toString()
            style {
                if (it.toInt() < 18) {
                    backgroundColor += c("#8b0000")
                    textFill = Color.WHITE
                }
            }
        }
    }

}
