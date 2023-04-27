package com.example.practica02.repository

import com.example.practica02.model.Dates
import java.util.Calendar

val dateList = mutableListOf(
    Dates.Month("Abril", getMonth(2023, 4, 1)),
    Dates.Month("Mayo", getMonth(2023, 5, 1)),
    Dates.Month("Junio", getMonth(2023, 6, 1)),
)

fun getMonth(year: Int, numberMonth: Int, initialDay: Int): List<Dates.Day> {
    val calendar = Calendar.getInstance()
    calendar.set(year, numberMonth, initialDay)

    val days = mutableListOf<Dates.Day>()

    while (calendar.get(Calendar.MONTH) == numberMonth) {
        if (calendar.get(Calendar.DAY_OF_WEEK) != Calendar.SATURDAY && calendar.get(Calendar.DAY_OF_WEEK) != Calendar.SUNDAY) {
            val dayName = when (calendar.get(Calendar.DAY_OF_WEEK)) {
                Calendar.MONDAY -> "Lunes"
                Calendar.TUESDAY -> "Martes"
                Calendar.WEDNESDAY -> "Miércoles"
                Calendar.THURSDAY -> "Jueves"
                Calendar.FRIDAY -> "Viernes"
                else -> ""
            }
            val numberDay = calendar.get(Calendar.DAY_OF_MONTH)
            days.add(Dates.Day(dayName, numberDay, false, false, false))
        }
        calendar.add(Calendar.DAY_OF_MONTH, 1)
    }
    return days
}