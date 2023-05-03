package com.example.practica02.adapter


import android.app.AlertDialog
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.practica02.R
import com.example.practica02.model.AttendanceInfo
import com.example.practica02.model.Person
import com.example.practica02.updateAttendanceList

class AttendanceRecyclerAdapter(
    private val attendanceInfoList: MutableList<AttendanceInfo>,
    private val actualStudent: Person.Student
) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return when (viewType) {
            0 -> {
                val view = layoutInflater.inflate(R.layout.month_header_item, parent, false)
                MonthViewHolder(view)
            }

            1 -> {
                val view = layoutInflater.inflate(R.layout.day_list_item, parent, false)
                DayViewHolder(view)
            }

            else -> throw IllegalArgumentException("Invalid view type")
        }
    }

    override fun getItemCount(): Int = attendanceInfoList.size

    override fun getItemViewType(position: Int): Int {
        return when (attendanceInfoList[position]) {
            is AttendanceInfo.Month -> 0
            is AttendanceInfo.Day -> 1
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (val item = attendanceInfoList[position]) {
            is AttendanceInfo.Month -> (holder as MonthViewHolder).bind(item)
            is AttendanceInfo.Day -> (holder as DayViewHolder).bind(item)
        }
    }

    inner class MonthViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val monthTextView: TextView = itemView.findViewById(R.id.textView1)
        fun bind(item: AttendanceInfo.Month) {
            monthTextView.text = item.nameMonth
        }
    }

    inner class DayViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val dayTextView: TextView = itemView.findViewById(R.id.textView1)
        fun bind(item: AttendanceInfo.Day) {

            val color = ContextCompat.getColor(
                dayTextView.context, when (item.typeAttendance) {
                    "Vacaciones" -> R.color.attendance_dialog_holidays
                    "Clases" -> R.color.attendance_dialog_center_study
                    else -> R.color.attendance_dialog_center_formation
                }
            )
            dayTextView.setTextColor(color)

            val completeDayName = "${item.numberDay} ${item.nameDay}"
            dayTextView.text = completeDayName
            dayTextView.setOnClickListener {

                val attendanceTypeDialogBuilder = AlertDialog.Builder(itemView.context)
                val attendanceDialogView = LayoutInflater.from(itemView.context)
                    .inflate(R.layout.attendance_type_dialog, null)
                attendanceTypeDialogBuilder.setView(attendanceDialogView)
                attendanceTypeDialogBuilder.setTitle(completeDayName)


                val attendanceTypeDialog = attendanceTypeDialogBuilder.create()
                attendanceTypeDialog.show()

                val formationLabel =
                    attendanceDialogView.findViewById<TextView>(R.id.attendanceDialogLabelFormation)
                formationLabel.setOnClickListener {
                    Log.i("PRUEBA", actualStudent.name + item.attendanceListPosition)
                    updateAttendanceList(actualStudent, item.attendanceListPosition, "Formación")
                }

                val holidaysLabel =
                    attendanceDialogView.findViewById<TextView>(R.id.attendanceDialogLabelHolidays)
                holidaysLabel.setOnClickListener {
                    Log.i("PRUEBA", actualStudent.name + item.attendanceListPosition)
                    updateAttendanceList(actualStudent, item.attendanceListPosition, "Vacaciones")
                }

                val centerStudyLabel =
                    attendanceDialogView.findViewById<TextView>(R.id.attendanceDialogLabelStudyCenter)
                centerStudyLabel.setOnClickListener {
                    Log.i("PRUEBA", actualStudent.name + item.attendanceListPosition)
                    updateAttendanceList(actualStudent, item.attendanceListPosition, "Clases")
                }
            }
        }
    }
}