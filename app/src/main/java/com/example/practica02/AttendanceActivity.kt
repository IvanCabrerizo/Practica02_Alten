package com.example.practica02

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.practica02.adapter.AttendanceRecyclerAdapter
import com.example.practica02.databinding.ActivityAttendanceBinding
import com.example.practica02.model.Person
import com.example.practica02.repository.transformDates
import com.google.android.material.appbar.AppBarLayout

class AttendanceActivity : AppCompatActivity() {

    private val binding by lazy { ActivityAttendanceBinding.inflate(layoutInflater) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val actualStudent = studentList[intent.getIntExtra("STUDENT", 0)]
        binding.avatar.glideUrl(actualStudent.photo)
        val listener = AppBarLayout.OnOffsetChangedListener { appBarLayout, verticalOffset ->
            val totalScrollRange = appBarLayout.totalScrollRange
            if (verticalOffset + totalScrollRange == 0) {
                binding.nombre2.text = actualStudent.name
            } else {
                binding.nombre2.text = ""
                binding.nombre.text = actualStudent.name + " " +actualStudent.surname
            }
        }
        binding.appbarLayout.addOnOffsetChangedListener(listener)
        initRecyclerView(actualStudent)

        binding.floatingButton.setOnClickListener{


        }
    }

    fun initRecyclerView(actualStudent: Person.Student) {
        val currentAttendanceList =
            transformDates(actualStudent.attendanceList)
        val recyclerView = binding.AttendanceListCalendar
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = AttendanceRecyclerAdapter(currentAttendanceList, actualStudent)
    }
}