package ru.skillbranch.devintensive.utils

object Utils {
    fun parseFullName (fullName: String?): Pair<String?, String?> {
        val parts : List<String>? = fullName?.split(" ")
        var firstName = parts?.getOrNull(0)
        var lastName = parts?.getOrNull(1)
        return Pair (firstName, lastName)
//      return firstName to lastName    // Задается пара: ключ-значение?
    }

    fun transliteration(payload: String, divider: String = " ") : String {
        return " "
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    fun toInitials(firstName: String?, lastName: String?): String? {
        return " "
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}