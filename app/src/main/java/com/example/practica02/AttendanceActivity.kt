package com.example.practica02

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
        val appBarLayoutListener = setupOffsetChangedListener(actualStudent)

        with(binding) {
            attendanceImgStudentPhoto.imageUrl(actualStudent.photo)
            attendanceAppbarLayout.addOnOffsetChangedListener(appBarLayoutListener)
            attendanceBtnChangeLayout.setOnClickListener {
                checkLayout(actualStudent)
            }
        }

        initRecyclerView(actualStudent)
    }

    private fun setupOffsetChangedListener(actualStudent: Person.Student): AppBarLayout.OnOffsetChangedListener {
        val completeName = "${actualStudent.name} ${actualStudent.surname}"
        val offSetChangedListener =
            AppBarLayout.OnOffsetChangedListener { appBarLayout, verticalOffset ->
                val totalScrollRange = appBarLayout.totalScrollRange
                if (verticalOffset + totalScrollRange == 0) {
                    binding.attendanceLabelCollapsedName.text = actualStudent.name
                } else {
                    binding.attendanceLabelCollapsedName.text = ""
                    binding.attendanceLabelName.text = completeName
                }
            }
        return offSetChangedListener
    }

    private fun checkLayout(student: Person.Student) {
        isGridLayout = !isGridLayout
        if(isGridLayout){
            binding.attendanceBtnChangeLayout.setImageResource(android.R.drawable.ic_menu_sort_by_size)
        }
        else{
            binding.attendanceBtnChangeLayout.setImageResource(android.R.drawable.ic_dialog_dialer)
        }
        initRecyclerView(student)
    }

    private fun initRecyclerView(actualStudent: Person.Student) {
        val currentAttendanceList =
            transformDates(actualStudent.attendanceList, binding.attendanceListCalendar.context)
        val attendanceAdapter =
            AttendanceRecyclerAdapter(currentAttendanceList, actualStudent, isGridLayout)
        val recyclerView = binding.attendanceListCalendar
        val gridLayoutManager = GridLayoutManager(this, if (isGridLayout) 5 else 1)

        recyclerView.layoutManager = gridLayoutManager
        recyclerView.adapter = attendanceAdapter

        gridLayoutManager.spanSizeLookup = object : GridLayoutManager.SpanSizeLookup() {
            override fun getSpanSize(position: Int): Int {
                return when (attendanceAdapter.getItemViewType(
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