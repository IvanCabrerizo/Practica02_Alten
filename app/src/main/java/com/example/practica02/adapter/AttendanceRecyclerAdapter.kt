package com.example.practica02.adapter


import android.app.AlertDialog
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.practica02.R
import com.example.practica02.databinding.DayListItemBinding
import com.example.practica02.databinding.MonthHeaderItemBinding
import com.example.practica02.model.AttendanceInfo
import com.example.practica02.model.Person
import com.example.practica02.repository.updateAttendanceList
import com.google.android.material.button.MaterialButton
import com.google.android.material.snackbar.Snackbar

class AttendanceRecyclerAdapter(
    private val attendanceInfoList: MutableList<AttendanceInfo>,
    private val actualStudent: Person.Student,
    private var isGridLayout: Boolean,
) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return when (viewType) {
            0 -> {
                val monthBinding = MonthHeaderItemBinding.inflate(layoutInflater , parent, false)
                MonthViewHolder(monthBinding)
            }

            1 -> {
                val dayBinding = DayListItemBinding.inflate(layoutInflater , parent, false)
                DayViewHolder(dayBinding)
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

    inner class MonthViewHolder(private val monthBinding: MonthHeaderItemBinding) : RecyclerView.ViewHolder(monthBinding.root) {
        fun bind(item: AttendanceInfo.Month) {
            monthBinding.textView1.text = item.nameMonth
        }
    }

    inner class DayViewHolder(private val dayBinding: DayListItemBinding) : RecyclerView.ViewHolder(dayBinding.root) {
        fun bind(item: AttendanceInfo.Day) {
            val completeDayName = "${item.nameDay} ${item.numberDay}"
            val shortName = "${item.nameDay.first()} ${item.numberDay}"
            val previousState = item.typeAttendance
            val color = ContextCompat.getColor(
                dayBinding.textView1.context, when (item.typeAttendance) {
                    "Vacaciones" -> R.color.attendance_dialog_holidays
                    "Clases" -> R.color.attendance_dialog_center_study
                    else -> R.color.attendance_dialog_center_formation
                }
            )
            dayBinding.textView1.setTextColor(color)

            if (isGridLayout) {
                dayBinding.textView1.text = shortName
            } else {
                dayBinding.textView1.text = completeDayName
            }

            dayBinding.textView1.setOnClickListener {

                val attendanceTypeDialogBuilder = AlertDialog.Builder(itemView.context)
                val attendanceDialogView = LayoutInflater.from(itemView.context)
                    .inflate(R.layout.attendance_type_dialog, null)
                attendanceTypeDialogBuilder.setView(attendanceDialogView)


                val attendanceTypeDialog = attendanceTypeDialogBuilder.create()
                attendanceTypeDialog.show()

                val dayLabel =
                    attendanceDialogView.findViewById<TextView>(R.id.attendanceDialogLabelActualDay)
                dayLabel.text = completeDayName

                val formationLabel =
                    attendanceDialogView.findViewById<TextView>(R.id.attendanceDialogLabelFormation)
                formationLabel.setOnClickListener {
                    updateAttendanceList(actualStudent, item.attendanceListPosition, "Formación")
                    item.typeAttendance = "Formación"
                    showSnackbar(item, previousState, adapterPosition)
                    notifyItemChanged(adapterPosition)
                    attendanceTypeDialog.dismiss()
                }

                val holidaysLabel =
                    attendanceDialogView.findViewById<TextView>(R.id.attendanceDialogLabelHolidays)
                holidaysLabel.setOnClickListener {
                    updateAttendanceList(actualStudent, item.attendanceListPosition, "Vacaciones")
                    item.typeAttendance = "Vacaciones"
                    showSnackbar(item, previousState, adapterPosition)
                    notifyItemChanged(adapterPosition)
                    attendanceTypeDialog.dismiss()
                }

                val centerStudyLabel =
                    attendanceDialogView.findViewById<TextView>(R.id.attendanceDialogLabelStudyCenter)
                centerStudyLabel.setOnClickListener {
                    updateAttendanceList(actualStudent, item.attendanceListPosition, "Clases")
                    item.typeAttendance = "Clases"
                    showSnackbar(item, previousState, adapterPosition)
                    notifyItemChanged(adapterPosition)
                    attendanceTypeDialog.dismiss()
                }

                val cancelButton =
                    attendanceDialogView.findViewById<MaterialButton>(R.id.attendanceDialogButtonCancel)
                cancelButton.setOnClickListener {
                    attendanceTypeDialog.dismiss()
                }
            }
        }

        private fun showSnackbar(item: AttendanceInfo.Day, attendanceType: String, position: Int) {
            val snackbar = Snackbar.make(
                dayBinding.textView1,
                "Asistencia cambiada a $attendanceType",
                Snackbar.LENGTH_LONG
            )

            snackbar.setAction("Deshacer") {
                updateAttendanceList(actualStudent, item.attendanceListPosition, attendanceType)
                item.typeAttendance = attendanceType
                notifyItemChanged(position)
            }
            snackbar.show()
        }
    }
}