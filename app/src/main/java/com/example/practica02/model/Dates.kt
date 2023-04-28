package com.example.practica02.model

data class Day(
    val dayName: String,
    val number: Int,
    val monthName: String,
    val trainingDay: Boolean,
    val freeDay: Boolean,
    val schoolDay: Boolean,
)