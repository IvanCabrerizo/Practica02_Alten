package com.example.practica02.model

data class Attendance(
    val dateAttendance: String,
    val typeAttendance: String,
)

sealed class AttendanceInfo {

    data class Month(
        val nameMonth: String,
    ) : AttendanceInfo()

    data class Day(
        val numberDay: Int,
        val nameDay: String,
        var typeAttendance: String,
        val attendanceListPosition: Int,
        val correspondingMonth: String,
    ) : AttendanceInfo()
}