package ru.skillbranch.devintensive.models

import java.util.*

abstract class BaseMessage(
    val id: String,
    val from: User?,
    val chat: Chat,
    val payload: Any?,
    val isIncoming: Boolean = false,
    val date: Date = Date()
){


    data class Chat (val id: String, val from: User?, val isIncoming: Boolean = false, val date: Date = Date())

    abstract fun formatMessage(): String

    companion object AbstractFactory {
        var lastId = -1
        fun makeMessage(from: User?, chat: Chat, date: Date = Date(), type: String, payload: Any?, isIncoming: Boolean = false): BaseMessage {
            lastId++
            return when (type) {
                "image" -> AbstractFactory.TextMessage.ImageMessage("$lastId", from, chat, date = date, image = payload as String)
                else -> TextMessage("$lastId", from, chat, date = date, text = payload as String) //Лана получила изображение "https://anyurl.com" 20 минут назад
            }
        }

        class TextMessage(
            id: String,
            from: User?,
            chat: Chat,
            isIncoming: Boolean = false,
            date: Date = Date(),
            var text: String?
        ) : BaseMessage(id, from, chat, text, isIncoming, date) {
            override fun formatMessage(): String {
                return "$id, $from/$chat, text"

        }

        class ImageMessage(
            id: String,
            from: User?,
            chat: Chat,
            isIncoming: Boolean = false,
            date: Date = Date(),
            var image: String?
        ) : BaseMessage(id, from, chat, image, isIncoming, date) {
                override fun formatMessage(): String {
                    return "$id, $from/$chat, image"
                }

            }
    }
} }