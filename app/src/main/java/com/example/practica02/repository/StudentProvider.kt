package com.example.practica02.repository

import com.example.practica02.adapter.AttendanceRecyclerAdapter
import com.example.practica02.model.Person
import com.example.practica02.repository.attendancesCadiz
import com.example.practica02.repository.attendancesSevilla

fun updateAttendanceList(student: Person.Student, positionList: Int, newAttendanceType: String) {
    val attendancePosition = student.attendanceList[positionList]
    val newAttendance = attendancePosition.copy(typeAttendance = newAttendanceType)
    student.attendanceList[positionList] = newAttendance
}

val studentList = listOf(
    Person.Student(
        "Alejandro",
        "Benitez Jimenez",
        "alejandro.benitez",
        "CES Juan Pablo II",
        "Cadiz",
        "https://pbs.twimg.com/profile_images/1249432648684109824/J0k1DN1T_400x400.jpg",
        tutorList.find { it -> it.userName == "sergio.perez" },
        attendancesCadiz,
    ),
    Person.Student(
        "Alejandro",
        "Damas",
        "alejandro.damas",
        "CES Sevilla",
        "Sevilla",
        "https://pbs.twimg.com/profile_images/1331694047166074881/cYOyBpso_400x400.jpg",
        tutorList.find { it -> it.userName == "javier.rodriguez" },
        attendancesSevilla,
    ),
    Person.Student(
        "Alvaro",
        "Revilla de la feria",
        "alvaro.revilla",
        "CES Sevilla",
        "Sevilla",
        "https://i1.sndcdn.com/avatars-000339084123-nag0p1-t240x240.jpg",
        tutorList.find { it -> it.userName == "isaac.reyes" },
        attendancesSevilla,
    ),
    Person.Student(
        "Daniel",
        "Mendiguchia",
        "daniel.mendiguchia",
        "CES Juan Pablo II",
        "Cadiz",
        "https://i1.sndcdn.com/artworks-FMJtFdT1qYskUjoP-y0ixOw-t500x500.jpg",
        tutorList.find { it -> it.userName == "rafael.pedros" },
        attendancesCadiz,
    ),
    Person.Student(
        "Iván",
        "Cabrerizo Alonso",
        "ivan.cabrerizo",
        "CES Juan Pablo II",
        "Cadiz",
        "https://i.pinimg.com/736x/a9/61/0f/a9610f604eac73134941886f82d7b54a.jpg",
        tutorList.find { it -> it.userName == "javier.rodriguez" },
        attendancesCadiz,
    ),
    Person.Student(
        "Javier",
        "Alvarez Jimenez",
        "javier.alvarez",
        "CES Juan Pablo II",
        "Cadiz",
        "https://qph.cf2.quoracdn.net/main-qimg-a8cafcc4acb60054c65bd209e7f5cc79.webp",
        tutorList.find { it -> it.userName == "rafael.pedros" },
        attendancesSevilla,
    ),
    Person.Student(
        "Javier",
        "Muñoa Carrasco",
        "javier.muñoa",
        "CES Sevilla",
        "Sevilla",
        "https://pbs.twimg.com/profile_images/980145664712740864/aNWjR7MB_400x400.jpg",
        tutorList.find { it -> it.userName == "isaac.reyes" },
        attendancesSevilla,
    ),
    Person.Student(
        "Javier",
        "Salguero",
        "javier.salguero",
        "CES Sevilla",
        "Sevilla",
        "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQy9q8rDMNMFpt37KMmi0xCHBM-Mex-dP3lFQ&usqp=CAU",
        tutorList.find { it -> it.userName == "juanj.rejon" },
        attendancesSevilla,
    ),
    Person.Student(
        "Jesus",
        "Monje",
        "jesus.monje",
        "CES Juan Pablo II",
        "Cadiz",
        "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQ3LYqTiD_abzJKCgRg2B22frsIz4C1IdNTSg&usqp=CAU",
        tutorList.find { it -> it.userName == "juanj.rejon" },
        attendancesCadiz,
    ),
    Person.Student(
        "Jose Maria",
        "Ortega Perfumo",
        "jose.ortegap",
        "CES Juan Pablo II",
        "Cadiz",
        "https://i.pinimg.com/280x280_RS/60/aa/f6/60aaf6de5a1fd948969fb8c5f866c1ee.jpg",
        tutorList.find { it -> it.userName == "carlos.dorado" },
        attendancesCadiz,
    ),
    Person.Student(
        "Manuel Alberto",
        "Segun Lopez",
        "manuel.segun",
        "CES Juan Pablo II",
        "Cadiz",
        "https://techbriefly.com/wp-content/uploads/2023/02/AI-impersonation-Fake-name-generators-this-person-does-not-exist-images-and-more-1.jpg",
        tutorList.find { it -> it.userName == "javier.rodriguez" },
        attendancesCadiz,
    ),
    Person.Student(
        "Matias",
        "Jarquez Ahucha",
        "matias.jarquez",
        "CES Juan Pablo II",
        "Cadiz",
        "https://i.stack.imgur.com/5Kgaq.jpg?s=256&g=1",
        tutorList.find { it -> it.userName == "carlos.dorado" }),
    Person.Student(
        "Pablo",
        "Torres Marmol",
        "pablo.torres",
        "CES Sevilla",
        "Sevilla",
        "https://p16-va-tiktok.ibyteimg.com/img/musically-maliva-obj/f2906cfb9287957b8a8cbf815fc7b71a~c5_720x720.jpeg",
        tutorList.find { it -> it.userName == "sergio.perez" },
        attendancesCadiz,
    ),
)
