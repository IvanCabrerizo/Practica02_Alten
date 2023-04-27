package com.example.practica02.adapter


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.practica02.R
import com.example.practica02.model.Dates
import com.example.practica02.model.Person

class AttendanceRecyclerAdapter(private val dateList: List<Dates.Month>) :
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

    override fun getItemCount(): Int = dateList.size

    override fun onBindViewHolder(holder: AttendanceViewHolder, position: Int) {
        val item = dateList[position]
        holder.render(item)
    }
}