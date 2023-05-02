package com.example.practica02.adapter


import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.practica02.R
import com.example.practica02.model.AttendanceInfo

class AttendanceRecyclerAdapter(private val attendanceInfoList: List<AttendanceInfo>) :
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
        return attendanceInfoList[position].viewType
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val item = attendanceInfoList[position]
        when (item) {
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
            val completeDayName = "${item.numberDay} ${item.nameDay}"
            dayTextView.text = completeDayName
        }
    }
}