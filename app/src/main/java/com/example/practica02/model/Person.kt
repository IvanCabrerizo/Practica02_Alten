package com.example.practica02.model

sealed class Person {
    abstract val name: String
    abstract val surname: String
    abstract val userName: String

    data class Student(
        override val name: String,
        override val surname: String,
        override val userName: String,
        val studyCenter: String,
        val city: String,
        val photo: String,
        val tutor: Tutor?,
        var attendanceList: MutableList<Attendance>
    ) : Person() {
        val mail: String = "$userName@alten.es"
    }

    data class Tutor(
        override val name: String,
        override val surname: String,
        override val userName: String,
    ) : Person()
}
