package com.example.practica02.model

sealed class Person {
    abstract val name: String
    abstract val surname: String

    data class Student(
        override val name: String,
        override val surname: String,
        val mail: String,
        val studyCenter: String,
        val city: String,
        val photo: String,
        val tutorId: Int,
        val attendanceList: MutableList<Attendance>,
    ) : Person()

    data class Tutor(
        override val name: String,
        override val surname: String,
        val id: Int,
    ) : Person()
}
