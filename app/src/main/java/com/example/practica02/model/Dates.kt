package com.example.practica02.model

data class Attendance(
    val dateAttendance: String,
    val typeAttendance: String,
)

sealed class AttendanceInfo {
    abstract val viewType: Int

    data class Month(
        val nameMonth: String
    ) : AttendanceInfo() {
        override val viewType = 0
    }

    data class Day(
        val numberDay: Int,
        val nameDay: String,
        val typeAttendance: String
    ) : AttendanceInfo() {
        override val viewType = 1
    }
}