package com.example.practica02.adapter


import android.app.AlertDialog
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
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
                val monthBinding = MonthHeaderItemBinding.inflate(layoutInflater, parent, false)
                MonthViewHolder(monthBinding)
            }

            1 -> {
                val dayBinding = DayListItemBinding.inflate(layoutInflater, parent, false)
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

    inner class MonthViewHolder(private val monthBinding: MonthHeaderItemBinding) :
        RecyclerView.ViewHolder(monthBinding.root) {
        fun bind(item: AttendanceInfo.Month) {
            monthBinding.monthHeaderItemLabelMonthName.text = item.nameMonth
        }
    }

    inner class DayViewHolder(private val dayBinding: DayListItemBinding) :
        RecyclerView.ViewHolder(dayBinding.root) {
        fun bind(item: AttendanceInfo.Day) {
            val completeDayName = "${item.nameDay} ${item.numberDay} de ${item.correspondingMonth}"
            val shortMessage = "El dia ${item.numberDay} de ${item.correspondingMonth} estuvo de ${item.typeAttendance}"
            val shortName = "${item.nameDay.first()} ${item.numberDay}"
            val previousState = item.typeAttendance
            val color = ContextCompat.getColor(
                dayBinding.dayListItemLabelDayName.context, when (item.typeAttendance) {
                    "Vacaciones" -> R.color.attendance_dialog_holidays
                    "Clases" -> R.color.attendance_dialog_center_study
                    else -> R.color.attendance_dialog_center_formation
                }
            )

            with(dayBinding){
                dayListItemLabelDayName.setTextColor(color)
                dayListItemLabelDayName.text = if (isGridLayout) shortName else completeDayName
                dayListItemLabelDayName.setOnClickListener {
                    Toast.makeText(dayListItemLabelDayName.context, shortMessage, Toast.LENGTH_SHORT).show()
                }
                showLongAlertDialog(this, this@DayViewHolder, completeDayName, item, previousState)
            }
        }

        private fun showUndoDialog(item: AttendanceInfo.Day, attendanceType: String, position: Int) {
            Snackbar.make(
                dayBinding.dayListItemLabelDayName,
                "Asistencia cambiada a ${item.typeAttendance}",
                Snackbar.LENGTH_LONG
            )
            .setAction("Deshacer") {
                updateAttendanceList(actualStudent, item.attendanceListPosition, attendanceType)
                item.typeAttendance = attendanceType
                notifyItemChanged(position)
            }
            .show()
        }

        private fun showLongAlertDialog(
            dayListItemBinding: DayListItemBinding,
            dayViewHolder: DayViewHolder,
            completeDayName: String,
            item: AttendanceInfo.Day,
            previousState: String
        ) {
            dayListItemBinding.dayListItemLabelDayName.setOnLongClickListener {

                val attendanceTypeDialogBuilder = AlertDialog.Builder(dayViewHolder.itemView.context)
                val attendanceDialogView = LayoutInflater.from(dayViewHolder.itemView.context)
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
                    dayViewHolder.showUndoDialog(item, previousState, dayViewHolder.adapterPosition)
                    notifyItemChanged(dayViewHolder.adapterPosition)
                    attendanceTypeDialog.dismiss()
                }

                val holidaysLabel =
                    attendanceDialogView.findViewById<TextView>(R.id.attendanceDialogLabelHolidays)
                holidaysLabel.setOnClickListener {
                    updateAttendanceList(actualStudent, item.attendanceListPosition, "Vacaciones")
                    item.typeAttendance = "Vacaciones"
                    dayViewHolder.showUndoDialog(item, previousState, dayViewHolder.adapterPosition)
                    notifyItemChanged(dayViewHolder.adapterPosition)
                    attendanceTypeDialog.dismiss()
                }

                val centerStudyLabel =
                    attendanceDialogView.findViewById<TextView>(R.id.attendanceDialogLabelStudyCenter)
                centerStudyLabel.setOnClickListener {
                    updateAttendanceList(actualStudent, item.attendanceListPosition, "Clases")
                    item.typeAttendance = "Clases"
                    dayViewHolder.showUndoDialog(item, previousState, dayViewHolder.adapterPosition)
                    notifyItemChanged(dayViewHolder.adapterPosition)
                    attendanceTypeDialog.dismiss()
                }

                val cancelButton =
                    attendanceDialogView.findViewById<MaterialButton>(R.id.attendanceDialogButtonCancel)
                cancelButton.setOnClickListener {
                    attendanceTypeDialog.dismiss()
                }
                return@setOnLongClickListener true
            }
        }
    }
}