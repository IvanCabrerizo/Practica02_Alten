package com.example.practica02

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.practica02.adapter.AttendanceRecyclerAdapter
import com.example.practica02.databinding.ActivityAttendanceBinding
import com.example.practica02.repository.transformDates

class AttendanceActivity : AppCompatActivity() {

    private val binding by lazy { ActivityAttendanceBinding.inflate(layoutInflater) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        initRecyclerView()
    }

    fun initRecyclerView() {
        val currentAttendanceList =
            transformDates(studentList[intent.getIntExtra("STUDENT", 0)].attendanceList)
        val recyclerView = binding.AttendanceListCalendar
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = AttendanceRecyclerAdapter(currentAttendanceList, studentList[intent.getIntExtra("STUDENT", 0)])
    }
}