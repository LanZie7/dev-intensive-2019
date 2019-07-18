package ru.skillbranch.devintensive.models

import ru.skillbranch.devintensive.extensions.humanizeDiff
import java.util.*

abstract class BaseMessage(
    val id: String,
    val from: User?,
    val chat: Chat,
//    val payload: Any?,
    val isIncoming: Boolean = false,
    val date: Date = Date()
){


//    data class Chat (val id: String, val from: User?, val isIncoming: Boolean = false, val date: Date = Date())

    abstract fun formatMessage(): String

    companion object AbstractFactory {
        var lastId = -1
        fun makeMessage(from: User?, chat: Chat, date: Date = Date(), type: String = "text", isIncoming: Boolean = false): BaseMessage {
            lastId++
            return when (type) {
                "image" -> ImageMessage("$lastId", from, chat, date = date, isIncoming = false, image = "image")
                    else -> TextMessage("$lastId", from, chat, date = date, isIncoming = false, text = "text") //Лана получила изображение "https://anyurl.com" 20 минут назад
            }
        }

        class TextMessage(
            id: String,
            from: User?,
            chat: Chat,
            isIncoming: Boolean = false,
            date: Date = Date(),
            var text: String?
        ) : BaseMessage(id, from, chat, date = date, isIncoming = false) {
            override fun formatMessage(): String =
                "id: $id ${from?.firstName} ${if(isIncoming) "получил(а)" else "отправил(а)"} сообщение $text ${date.humanizeDiff()}"

        }

        class ImageMessage(
            id: String,
            from: User?,
            chat: Chat,
            isIncoming: Boolean = false,
            date: Date = Date(),
            var image: String?
        ) : BaseMessage(id, from, chat, date = date, isIncoming = false) {
            override fun formatMessage(): String =
                "id: $id ${from?.firstName} ${if(isIncoming) "получил(а)" else "отправил(а)"} сообщение $image ${date.humanizeDiff()}"
                }

            }
    }