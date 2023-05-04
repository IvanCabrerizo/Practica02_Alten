package com.example.practica02

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.practica02.adapter.StudentsViewPagerAdapter
import com.example.practica02.databinding.ActivityStudentsBinding
import com.example.practica02.model.Person
import com.example.practica02.repository.studentList
import com.google.android.material.tabs.TabLayoutMediator

class StudentsActivity : AppCompatActivity() {
    private val binding by lazy { ActivityStudentsBinding.inflate(layoutInflater) }
    private val adapter by lazy { StudentsViewPagerAdapter(studentList, this) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        with(binding){
            setupAdapter()
            tabConfigure(studentList)
            studentActivityBtnStudentCalendar.setOnClickListener{
                startActivity(newIntent(studentActivityBtnStudentCalendar.context, studentActivityPagerAlumInfo.currentItem))
            }
        }
    }

    private fun ActivityStudentsBinding.tabConfigure(studentList: List<Person.Student>) {
        val tabLayoutMediator = TabLayoutMediator(
            studentActivityTabLayoutNameVisor, studentActivityPagerAlumInfo
        ) { tab, position ->
            val studentNamePosition =
                "${studentList[position].name} ${studentList[position].surname}"
            tab.text = studentNamePosition
        }
        tabLayoutMediator.attach()
    }

    private fun ActivityStudentsBinding.setupAdapter() {
        studentActivityPagerAlumInfo.adapter = adapter
    }

    private fun newIntent(context: Context, actualStudentPosition: Int): Intent{
        return Intent(context, AttendanceActivity::class.java).apply {
            putExtra("STUDENT", actualStudentPosition)
        }
    }
}