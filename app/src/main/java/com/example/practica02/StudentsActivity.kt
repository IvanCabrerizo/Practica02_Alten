package com.example.practica02

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.practica02.databinding.ActivityStudentsBinding
import com.google.android.material.tabs.TabLayoutMediator

class StudentsActivity : AppCompatActivity() {
    private val binding by lazy { ActivityStudentsBinding.inflate(layoutInflater) }
    private val adapter by lazy { StudentsViewPagerAdapter(this) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.setupAdapter()
        tabConfigure()
    }

    private fun tabConfigure() {
        val tabLayoutMediator = TabLayoutMediator(binding.tabLayout, binding.pager
        ) { tab, position ->
            val studentNamePosition =
                "${studentList[position].name} ${studentList[position].surname}"
            tab.text = studentNamePosition
        }
        tabLayoutMediator.attach()
    }

    private fun ActivityStudentsBinding.setupAdapter(){
        pager.adapter = adapter
    }
}