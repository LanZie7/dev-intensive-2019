package ru.skillbranch.devintensive.models

import ru.skillbranch.devintensive.utils.Utils
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

        println("It's Alive!!! \n" +
                "${if (lastName === "Doe") "His name is $firstName $lastName" else "And his name is $firstName $lastName!!! "}\n" )
    }

    companion object Factory{   // Объект Factory будет обладать некими статическими фун-ми,
                                // к этим фун-ям можно обратиться из любой части кода
        /**
         * Паттерн проектирования Factory позволяет создавать экземпляры объектов
         * и удобен перед созданием объекта, н-р, сделать к-л преобразования (отформатировать код),
         * позволяет не отслеживать то, что будет автоматически создаваться (инкрементные идентификаторы).
         * С помощью Factory можно провести к-л подготовительные вычисления
         */
        private var lastId : Int = -1       // Приватное поле
        fun makeUser(fullName: String?) : User{  // В методе makeUser значение инкрементируется,
                                                 // затем передается в качестве идентификатора в конструктор User
            lastId++

//            val parts : List<String>? = fullName?.split(" ")    // Содержащая строки кол-ция

//            var firstName = parts?.getOrNull(0)  // Если в нашей коллекции нет объекта с индексом 0,
//                                                              // то возвращается null
//            var lastName = parts?.getOrNull(1)   // Возвращение 1-го индекса коллекции

            // Деструктуриализация / Деструктурное присваивание и получение доступа к опред. компонентам объекта
            val (firstName, lastName) = Utils.parseFullName(fullName)
            return User(id="$lastId", firstName = firstName, lastName = lastName)    // Передача ИФ во вторичный конструктор
        }

    }
}