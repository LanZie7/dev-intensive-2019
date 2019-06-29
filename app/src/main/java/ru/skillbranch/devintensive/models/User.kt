package ru.skillbranch.devintensive.models

import java.util.*

/**
 * Created by LanZie7 on 29.06.2019
 */

class User(
    val id: String,
    var firstName: String?,
    var lastName: String?,
    var avatar: String?,
    var rating: Int = 0,
    var respect: Int = 0,
    val lastVisit: Date? = null,    // время последнего визита пользователя в сети
    val isOnline: Boolean = false,
    var introBit: String = "$firstName $lastName"
) {

    constructor(id: String, firstName: String?, lastName: String?) : this(
        id = id,
        firstName = firstName,
        lastName = lastName,
        avatar = null
    )

    constructor(id: String) : this(id, "John", "Doe")

    init {
        // Проинициализация поля introBit в блоке init
        //    var introBit: String = "tu tu ru tuuu"  // Поле сразу же проинициализировалось
        introBit = getIntro()             // Поле проинициализировано вызовом ф-ции,
                                                      // данное поле в конструкторе проинициализировать нельзя,
                                                      // поскольку в конструкторе нельзя проводить вычисления,
                                                      // для этого есть блоки инициализации
                                                      // но в конструкторе можно сделать интерполяцию
        // Использование фичи интерполирования, когда if возвращает конкретный р-т,
        // if - выражение, а не оператор
        println("It's Alive!!! \n" +
                "${if (lastName === "Doe") "His name is $firstName $lastName" else "And his name is $firstName $lastName!!! } "}\n" +
                "${getIntro()}!!!"
        )

        fun printMe() = println("""
            id: $id
            firstName: $firstName
            lastName: $lastName
            avatar: $avatar
            rating: $rating
            respect: $respect
            lastVisit: $lastVisit
            isOnline: $isOnline
        """.trimIndent()
            )
        }

        //fun printMe() = println("""   // Более короткая форма записи методов в Kotlin
        //        id: $id
        //        firstName: $firstName
        //        lastName: $lastName
        //        avatar: $avatar
        //        rating: $rating
        //        respect: $respect
        //        lastVisit: $lastVisit
        //        isOnline: $isOnline
        //    """.trimIndent())
    }

    private fun getIntro(): String {
        var firstName = String
        var lastName = String
        return """
            Hello Universe !!!
            Hello Universe ...

            Hello Universe !!!
            Hello Universe ...
            ${"\n\n\n"}
            $firstName $lastName
        """.trimIndent()
    }
