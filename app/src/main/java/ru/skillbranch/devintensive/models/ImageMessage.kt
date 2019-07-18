package ru.skillbranch.devintensive.models

import ru.skillbranch.devintensive.extensions.humanizeDiff
import java.util.*

class ImageMessage (
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