package com.example.practica02.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.practica02.databinding.AttendanceCalendarItemBinding
import com.example.practica02.model.Dates

class AttendanceViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    val binding = AttendanceCalendarItemBinding.bind(view)

    fun render(date: Dates.Month){
        with(binding) {
            textView1.text = date.name
            textView2.text = date.days.joinToString("\n") { "${it.name} ${it.number}" }
        }
    }
}