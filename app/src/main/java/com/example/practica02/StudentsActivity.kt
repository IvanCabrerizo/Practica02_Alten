package com.example.practica02

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
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

        binding.setupAdapter()
        binding.tabConfigure(studentList)
        binding.fragmentStudentBtnCalendar.setOnClickListener{
            val intent = Intent(this, AttendanceActivity::class.java)
            intent.putExtra("STUDENT", binding.pager.currentItem)
            startActivity(intent)
        }
    }

    private fun ActivityStudentsBinding.tabConfigure(studentList: List<Person.Student>) {
        val tabLayoutMediator = TabLayoutMediator(
            activityStudentTabLayoutNameVisor, activityStudentPagerAlumInfo
        ) { tab, position ->
            val studentNamePosition =
                "${studentList[position].name} ${studentList[position].surname}"
            tab.text = studentNamePosition
        }
        tabLayoutMediator.attach()
    }

    private fun ActivityStudentsBinding.setupAdapter() {
        activityStudentPagerAlumInfo.adapter = adapter
    }
}