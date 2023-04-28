package com.example.practica02.adapter


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.practica02.R
import com.example.practica02.model.Day

class AttendanceRecyclerAdapter(private val dayList: List<Day>) :
    RecyclerView.Adapter<AttendanceViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AttendanceViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return AttendanceViewHolder(
            layoutInflater.inflate(
                R.layout.attendance_calendar_item,
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int = dayList.size

    override fun onBindViewHolder(holder: AttendanceViewHolder, position: Int) {
        val item = dayList[position]
        holder.render(item)
    }
}