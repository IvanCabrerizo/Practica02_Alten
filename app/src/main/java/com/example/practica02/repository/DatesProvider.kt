package com.example.practica02.repository

import com.example.practica02.model.Day
import java.util.Calendar

val dayList =
    getDaysFromMonth(2023, 4, 1) + getDaysFromMonth(2023, 5, 1) + getDaysFromMonth(2023, 6, 1)

fun getDaysFromMonth(year: Int, numberMonth: Int, initialDay: Int): List<Day> {
    val calendar = Calendar.getInstance()
    calendar.set(year, numberMonth, initialDay)

    val days = mutableListOf<Day>()

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
            val monthName = when (calendar.get(Calendar.MONTH)) {
                Calendar.JANUARY -> "Enero"
                Calendar.FEBRUARY -> "Febrero"
                Calendar.MARCH -> "Marzo"
                Calendar.APRIL -> "Abril"
                Calendar.MAY -> "Mayo"
                Calendar.JUNE -> "Junio"
                Calendar.JULY -> "Julio"
                Calendar.AUGUST -> "Agosto"
                Calendar.SEPTEMBER -> "Septiembre"
                Calendar.OCTOBER -> "Octubre"
                Calendar.NOVEMBER -> "Noviembre"
                Calendar.DECEMBER -> "Diciembre"
                else -> ""
            }
            val numberDay = calendar.get(Calendar.DAY_OF_MONTH)
            days.add(Day(dayName, numberDay, monthName, false, false, false))
        }
        calendar.add(Calendar.DAY_OF_MONTH, 1)
    }
    return days
}