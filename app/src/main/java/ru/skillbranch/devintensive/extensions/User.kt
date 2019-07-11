package ru.skillbranch.devintensive.extensions

import ru.skillbranch.devintensive.models.User
import ru.skillbranch.devintensive.models.UserView
import ru.skillbranch.devintensive.utils.Utils
import java.util.*

fun User.toUserView() : UserView {  // Поскольку это data class, data mapping можно делать без обращения к экземпляру

    val nickName = Utils.transliteration("$firstName $lastName")
    val initials = Utils.toInitials(firstName, lastName)
//    val status = if(lastVisit == null) "Еще ни разу не был" else if (isOnline) "online" else "Последний раз был ${lastVisit?.humanizedDiff()}"

    return UserView (
        id,
        fullName = "$firstName $lastName",  // Конкатинация ИФ, кот. получаем из объекта User
        avatar = avatar,
        nickName = nickName,
        initials = initials
//        status = status )
    ) }

// Д/з: написать реализацию (расширение для объекта Date)
//private fun Date.humanizedDiff(date:Date = Date()): String {
//    return " "
//}
