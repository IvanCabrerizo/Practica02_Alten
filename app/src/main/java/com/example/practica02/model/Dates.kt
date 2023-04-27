package com.example.practica02.model

import java.util.Calendar

sealed class Dates {
    abstract val name: String

    data class Month(
        override val name: String,
        val days: List<Day>,
    ) : Dates()

    data class Day(
        override val name: String,
        val number: Int,
        val trainingDay: Boolean,
        val freeDay: Boolean,
        val schoolDay: Boolean,
    ) : Dates()
}