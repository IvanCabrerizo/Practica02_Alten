package com.example.practica02

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import com.example.practica02.adapter.AttendanceRecyclerAdapter
import com.example.practica02.databinding.ActivityAttendanceBinding
import com.example.practica02.model.Person
import com.example.practica02.repository.studentList
import com.example.practica02.repository.transformDates
import com.google.android.material.appbar.AppBarLayout

class AttendanceActivity : AppCompatActivity() {

    private val binding by lazy { ActivityAttendanceBinding.inflate(layoutInflater) }
    private var isGridLayout = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val actualStudent = studentList[intent.getIntExtra("STUDENT", 0)]
        binding.avatar.imageUrl(actualStudent.photo)
        val listener = AppBarLayout.OnOffsetChangedListener { appBarLayout, verticalOffset ->
            val totalScrollRange = appBarLayout.totalScrollRange
            if (verticalOffset + totalScrollRange == 0) {
                binding.nombre2.text = actualStudent.name
            } else {
                binding.nombre2.text = ""
                binding.nombre.text = actualStudent.name + " " + actualStudent.surname
            }
        }
        binding.appbarLayout.addOnOffsetChangedListener(listener)
        initRecyclerView(actualStudent)

        binding.floatingButton.setOnClickListener {
            isGridLayout = !isGridLayout
            initRecyclerView(actualStudent)
        }
    }

    private fun initRecyclerView(actualStudent: Person.Student) {
        val currentAttendanceList = transformDates(actualStudent.attendanceList)
        val recyclerView = binding.AttendanceListCalendar
        val gridLayoutManager = GridLayoutManager(this, if (isGridLayout) 5 else 1)

        recyclerView.layoutManager = gridLayoutManager

        recyclerView.adapter =
            AttendanceRecyclerAdapter(currentAttendanceList, actualStudent, isGridLayout)

        gridLayoutManager.spanSizeLookup = object : GridLayoutManager.SpanSizeLookup() {
            override fun getSpanSize(position: Int): Int {
                return when ((recyclerView.adapter as AttendanceRecyclerAdapter).getItemViewType(
                    position
                )) {
                    0 -> if (isGridLayout) 5 else 1
                    1 -> 1
                    else -> throw IllegalArgumentException("Invalid view type")
                }
            }
        }
    }
}