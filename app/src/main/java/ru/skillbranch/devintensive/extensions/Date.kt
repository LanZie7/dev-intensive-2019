package ru.skillbranch.devintensive.extensions

import java.text.SimpleDateFormat
import java.util.*

const val SECOND = 1000L
const val MINUTE = 60 * SECOND
const val HOUR = 60 * MINUTE
const val DAY = 24 * HOUR

fun Date.format(pattern:String = "HH:mm:ss dd.MM.yy"): String {    //Ф-ия расширения принимает стандартный паттерн
                                                                    // (в том виде,в кот. мы хотим отформатировать объект)
    val dateFormat = SimpleDateFormat(pattern, Locale("ru"))
    return dateFormat.format(this)
}

fun Date.add(value:Int, units: TimeUnits = TimeUnits.SECOND): Date {   //extension ф-ия позволит добавить к объекту даты определенно временной сдвиг,
                                                                       // кот. будет измеряться в задаваемыми нами величинами
    val time = this.time + when(units) {
        TimeUnits.SECOND -> value * SECOND
        TimeUnits.MINUTE -> value * MINUTE
        TimeUnits.HOUR -> value * HOUR
        TimeUnits.DAY -> value * DAY

    }
    this.time = time
    return this
}

//fun Date.humanizeDiff(): String = ""
//fun Date.humanizeDiff(date: Date): String = ""




    enum class TimeUnits{
        SECOND,
        MINUTE,
        HOUR,
        DAY
    }