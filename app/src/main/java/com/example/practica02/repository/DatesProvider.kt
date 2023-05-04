package com.example.practica02.repository

import android.content.Context
import com.example.practica02.R
import com.example.practica02.model.Attendance
import com.example.practica02.model.AttendanceInfo
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale


val attendancesCadiz = mutableListOf(
    Attendance("27/3/2023", "Formación"),
    Attendance("28/3/2023", "Formación"),
    Attendance("29/3/2023", "Formación"),
    Attendance("30/3/2023", "Formación"),
    Attendance("31/3/2023", "Formación"),
    Attendance("03/04/2023", "Vacaciones"),
    Attendance("04/04/2023", "Vacaciones"),
    Attendance("05/04/2023", "Vacaciones"),
    Attendance("06/04/2023", "Vacaciones"),
    Attendance("07/04/2023", "Vacaciones"),
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

val attendancesSevilla = mutableListOf(
    Attendance("27/3/2023", "Formación"),
    Attendance("28/3/2023", "Formación"),
    Attendance("29/3/2023", "Formación"),
    Attendance("30/3/2023", "Formación"),
    Attendance("31/3/2023", "Formación"),
    Attendance("03/04/2023", "Vacaciones"),
    Attendance("04/04/2023", "Vacaciones"),
    Attendance("05/04/2023", "Vacaciones"),
    Attendance("06/04/2023", "Vacaciones"),
    Attendance("07/04/2023", "Vacaciones"),
    Attendance("10/04/2023", "Formación"),
    Attendance("11/04/2023", "Formación"),
    Attendance("12/04/2023", "Formación"),
    Attendance("13/04/2023", "Formación"),
    Attendance("14/04/2023", "Clases"),
    Attendance("17/04/2023", "Formación"),
    Attendance("18/04/2023", "Formación"),
    Attendance("19/04/2023", "Formación"),
    Attendance("20/04/2023", "Clases"),
    Attendance("21/04/2023", "Formación"),
    Attendance("24/04/2023", "Formación"),
    Attendance("25/04/2023", "Formación"),
    Attendance("26/04/2023", "Vacaciones"),
    Attendance("27/04/2023", "Vacaciones"),
    Attendance("28/04/2023", "Vacaciones"),
    Attendance("01/05/2023", "Vacaciones"),
    Attendance("02/05/2023", "Formación"),
    Attendance("03/05/2023", "Formación"),
    Attendance("04/05/2023", "Clases"),
    Attendance("05/05/2023", "Formación"),
    Attendance("08/05/2023", "Formación"),
    Attendance("09/05/2023", "Formación"),
    Attendance("10/05/2023", "Formación"),
    Attendance("11/05/2023", "Formación"),
    Attendance("12/05/2023", "Formación"),
    Attendance("15/05/2023", "Formación"),
    Attendance("16/05/2023", "Formación"),
    Attendance("17/05/2023", "Formación"),
    Attendance("18/05/2023", "Clases"),
    Attendance("19/05/2023", "Formación"),
    Attendance("22/05/2023", "Formación"),
    Attendance("23/05/2023", "Formación"),
    Attendance("24/05/2023", "Formación"),
    Attendance("25/05/2023", "Formación"),
    Attendance("26/05/2023", "Formación"),
    Attendance("29/05/2023", "Formación"),
    Attendance("30/05/2023", "Formación"),
    Attendance("31/05/2023", "Formación"),
    Attendance("01/06/2023", "Clases"),
    Attendance("02/06/2023", "Formación"),
    Attendance("05/06/2023", "Formación"),
    Attendance("06/06/2023", "Formación"),
    Attendance("07/06/2023", "Formación"),
    Attendance("08/06/2023", "Vacaciones"),
    Attendance("09/06/2023", "Formación"),
    Attendance("12/06/2023", "Formación"),
    Attendance("13/06/2023", "Formación"),
    Attendance("14/06/2023", "Formación"),
    Attendance("15/06/2023", "Clases"),
    Attendance("16/06/2023", "Formación"),
)

fun transformDates(listAttendance: List<Attendance>, context: Context): MutableList<AttendanceInfo> {
    val dateFormat = SimpleDateFormat("dd/MM/yyyy", Locale.getDefault())
    val listAttendanceInfo = mutableListOf<AttendanceInfo>()

    for (attendancePosition in listAttendance.indices) {
        val attendanceDate = dateFormat.parse(listAttendance[attendancePosition].dateAttendance)
        val calendar = Calendar.getInstance()
        if (attendanceDate != null) {
            calendar.time = attendanceDate
        }

        val dayName = when (calendar.get(Calendar.DAY_OF_WEEK)) {
            Calendar.MONDAY -> context.getString(R.string.transformDates_monday)
            Calendar.TUESDAY -> context.getString(R.string.transformDates_tuesday)
            Calendar.WEDNESDAY -> context.getString(R.string.transformDates_wednesday)
            Calendar.THURSDAY -> context.getString(R.string.transformDates_thursday)
            Calendar.FRIDAY -> context.getString(R.string.transformDates_friday)
            Calendar.SATURDAY -> context.getString(R.string.transformDates_saturday)
            Calendar.SUNDAY -> context.getString(R.string.transformDates_sunday)
            else -> ""
        }
        val monthName = when (calendar.get(Calendar.MONTH)) {
            Calendar.JANUARY -> context.getString(R.string.transformDates_january)
            Calendar.FEBRUARY -> context.getString(R.string.transformDates_february)
            Calendar.MARCH -> context.getString(R.string.transformDates_march)
            Calendar.APRIL -> context.getString(R.string.transformDates_april)
            Calendar.MAY -> context.getString(R.string.transformDates_may)
            Calendar.JUNE -> context.getString(R.string.transformDates_june)
            Calendar.JULY -> context.getString(R.string.transformDates_july)
            Calendar.AUGUST -> context.getString(R.string.transformDates_august)
            Calendar.SEPTEMBER -> context.getString(R.string.transformDates_september)
            Calendar.OCTOBER -> context.getString(R.string.transformDates_october)
            Calendar.NOVEMBER -> context.getString(R.string.transformDates_november)
            Calendar.DECEMBER -> context.getString(R.string.transformDates_december)
            else -> ""
        }
        val dayNumber = calendar.get(Calendar.DAY_OF_MONTH)

        val day = AttendanceInfo.Day(dayNumber, dayName, listAttendance[attendancePosition].typeAttendance, attendancePosition)
        val month = AttendanceInfo.Month(monthName)

        if (month !in listAttendanceInfo) {
            listAttendanceInfo.add(month)
        }
        listAttendanceInfo.add(day)
    }
    return listAttendanceInfo
}
