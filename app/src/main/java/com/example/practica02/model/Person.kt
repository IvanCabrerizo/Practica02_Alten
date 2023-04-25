package com.example.practica02.model

sealed class Person{
    abstract val name: String
    abstract val lastName: String

    data class Student(
        override val name: String,
        override val lastName: String,
        val mail: String,
        val studyCenter: String,
        val city: String,
        val photo: String,
    ): Person()

    data class Tutor(
        override val name: String,
        override val lastName: String,
    ): Person()
}
