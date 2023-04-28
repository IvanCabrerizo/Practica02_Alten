package com.example.practica02.adapter

import android.graphics.Color
import android.util.Log
import android.view.View
import androidx.core.view.isGone
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import com.example.practica02.databinding.ActivityAttendanceBinding
import com.example.practica02.databinding.AttendanceCalendarItemBinding
import com.example.practica02.model.Day

private var actualMonth = ""
class AttendanceViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    private val binding = AttendanceCalendarItemBinding.bind(view)


    fun render(days: Day){
        with(binding) {
            if (actualMonth != days.monthName) {
                textView1.isVisible = true
                textView1.text = days.monthName
                actualMonth = days.monthName
            }
            else{
                textView1.isGone = true
            }
            textView2.text = days.dayName + days.number
            textView2.setOnClickListener {
                textView2.setTextColor(Color.RED)
            }
        }
    }
}