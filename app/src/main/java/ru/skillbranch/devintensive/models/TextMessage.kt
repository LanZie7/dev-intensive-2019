package ru.skillbranch.devintensive.models

import ru.skillbranch.devintensive.extensions.humanizedDiff
import java.util.*

class TextMessage (
    id: String,
    from: User?,
    chat: Chat,
    isIncoming: Boolean = false,
    date: Date = Date(),
    var text: String?
) : BaseMessage(id, from, chat, text, isIncoming, date) {
    override fun formatMessage(): String = "id: $id ${from?.firstName} ${if (isIncoming) "получил(а)" else "отправил(а)"} сообщение $text ${date.humanizedDiff()}"
    }