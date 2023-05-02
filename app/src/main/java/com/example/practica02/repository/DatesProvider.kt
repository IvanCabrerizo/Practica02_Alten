package com.example.practica02.repository

import com.example.practica02.model.Attendance
import com.example.practica02.model.AttendanceInfo
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale


val attendancesCadiz = listOf(
    Attendance("27/3/2023", "Formación"),
    Attendance("28/3/2023", "Formación"),
    Attendance("29/3/2023", "Formación"),
    Attendance("30/3/2023", "Formación"),
    Attendance("31/3/2023", "Formación"),
    Attendance("03/04/2023", "Formación"),
    Attendance("04/04/2023", "Formación"),
    Attendance("05/04/2023", "Formación"),
    Attendance("06/04/2023", "Formación"),
    Attendance("07/04/2023", "Formación"),
    Attendance("10/04/2023", "Clases"),
    Attendance("11/04/2023", "Formación"),
    Attendance("12/04/2023", "Formación"),
    Attendance("13/04/2023", "Formación"),
    Attendance("14/04/2023", "Formación"),
    Attendance("17/04/2023", "Formación"),
    Attendance("18/04/2023", "Formación"),
    Attendance("19/04/2023", "Formación"),
    Attendance("20/04/2023", "Formación"),
    Attendance("21/04/2023", "Formación"),
    Attendance("24/04/2023", "Clases"),
    Attendance("25/04/2023", "Formación"),
    Attendance("26/04/2023", "Formación"),
    Attendance("27/04/2023", "Formación"),
    Attendance("28/04/2023", "Formación"),
    Attendance("01/05/2023", "Vacaciones"),
    Attendance("02/05/2023", "Formación"),
    Attendance("03/05/2023", "Formación"),
    Attendance("04/05/2023", "Formación"),
    Attendance("05/05/2023", "Formación"),
    Attendance("08/05/2023", "Formación"),
    Attendance("09/05/2023", "Formación"),
    Attendance("10/05/2023", "Formación"),
    Attendance("11/05/2023", "Formación"),
    Attendance("12/05/2023", "Formación"),
    Attendance("15/05/2023", "Clases"),
    Attendance("16/05/2023", "Formación"),
    Attendance("17/05/2023", "Formación"),
    Attendance("18/05/2023", "Formación"),
    Attendance("19/05/2023", "Formación"),
    Attendance("22/05/2023", "Formación"),
    Attendance("23/05/2023", "Formación"),
    Attendance("24/05/2023", "Formación"),
    Attendance("25/05/2023", "Formación"),
    Attendance("26/05/2023", "Formación"),
    Attendance("29/05/2023", "Clases"),
    Attendance("30/05/2023", "Formación"),
    Attendance("31/05/2023", "Formación"),
    Attendance("01/06/2023", "Formación"),
    Attendance("02/06/2023", "Formación"),
    Attendance("05/06/2023", "Formación"),
    Attendance("06/06/2023", "Formación"),
    Attendance("07/06/2023", "Formación"),
    Attendance("08/06/2023", "Formación"),
    Attendance("09/06/2023", "Formación"),
    Attendance("12/06/2023", "Clases"),
    Attendance("13/06/2023", "Formación"),
    Attendance("14/06/2023", "Formación"),
    Attendance("15/06/2023", "Formación"),
    Attendance("16/06/2023", "Formación"),
)

val attendancesSevilla = listOf(
    Attendance("27/3/2023", "Centro"),
    Attendance("28/3/2023", "Centro"),
    Attendance("29/3/2023", "Centro"),
    Attendance("30/3/2023", "Centro"),
    Attendance("31/3/2023", "Centro"),
    Attendance("03/04/2023", "Centro"),
    Attendance("04/04/2023", "Centro"),
    Attendance("05/04/2023", "Centro"),
    Attendance("06/04/2023", "Centro"),
    Attendance("07/04/2023", "Centro"),
    Attendance("10/04/2023", "Centro"),
    Attendance("11/04/2023", "Centro"),
    Attendance("12/04/2023", "Centro"),
    Attendance("13/04/2023", "Centro"),
    Attendance("14/04/2023", "Centro"),
    Attendance("17/04/2023", "Centro"),
    Attendance("18/04/2023", "Centro"),
    Attendance("19/04/2023", "Centro"),
    Attendance("20/04/2023", "Centro"),
    Attendance("21/04/2023", "Centro"),
    Attendance("24/04/2023", "Centro"),
    Attendance("25/04/2023", "Centro"),
    Attendance("26/04/2023", "Centro"),
    Attendance("27/04/2023", "Centro"),
    Attendance("28/04/2023", "Centro"),
    Attendance("02/05/2023", "Centro"),
    Attendance("03/05/2023", "Centro"),
    Attendance("04/05/2023", "Centro"),
    Attendance("05/05/2023", "Centro"),
    Attendance("08/05/2023", "Centro"),
    Attendance("09/05/2023", "Centro"),
    Attendance("10/05/2023", "Centro"),
    Attendance("11/05/2023", "Centro"),
    Attendance("12/05/2023", "Centro"),
    Attendance("15/05/2023", "Centro"),
    Attendance("16/05/2023", "Centro"),
    Attendance("17/05/2023", "Centro"),
    Attendance("18/05/2023", "Centro"),
    Attendance("19/05/2023", "Centro"),
    Attendance("22/05/2023", "Centro"),
    Attendance("23/05/2023", "Centro"),
    Attendance("24/05/2023", "Centro"),
    Attendance("25/05/2023", "Centro"),
    Attendance("26/05/2023", "Centro"),
    Attendance("29/05/2023", "Centro"),
    Attendance("30/05/2023", "Centro"),
    Attendance("31/05/2023", "Centro"),
    Attendance("01/06/2023", "Centro"),
    Attendance("02/06/2023", "Centro"),
    Attendance("05/06/2023", "Centro"),
    Attendance("06/06/2023", "Centro"),
    Attendance("07/06/2023", "Centro"),
    Attendance("08/06/2023", "Centro"),
    Attendance("09/06/2023", "Centro"),
    Attendance("12/06/2023", "Centro"),
    Attendance("13/06/2023", "Centro"),
    Attendance("14/06/2023", "Centro"),
    Attendance("15/06/2023", "Centro"),
    Attendance("16/06/2023", "Centro"),
)

fun transformDates(listAttendance: List<Attendance>): MutableList<AttendanceInfo> {
    val dateFormat = SimpleDateFormat("dd/MM/yyyy", Locale.getDefault())
    val listAttendanceInfo = mutableListOf<AttendanceInfo>()

    for (attendance in listAttendance) {
        val attendanceDate = dateFormat.parse(attendance.dateAttendance)
        val calendar = Calendar.getInstance()
        calendar.time = attendanceDate

        val dayName = when (calendar.get(Calendar.DAY_OF_WEEK)) {
            Calendar.MONDAY -> "Lunes"
            Calendar.TUESDAY -> "Martes"
            Calendar.WEDNESDAY -> "Miércoles"
            Calendar.THURSDAY -> "Jueves"
            Calendar.FRIDAY -> "Viernes"
            Calendar.SATURDAY -> "Sabado"
            Calendar.SUNDAY -> "Domingo"
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
        val dayNumber = calendar.get(Calendar.DAY_OF_MONTH)

        val day = AttendanceInfo.Day(dayNumber, dayName, attendance.typeAttendance)
        val month = AttendanceInfo.Month(monthName)

        if(!listAttendanceInfo.contains(month)){
            listAttendanceInfo.add(month)
        }
        listAttendanceInfo.add(day)
    }
    return listAttendanceInfo
}
