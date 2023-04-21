package com.example.practica02

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.practica02.databinding.ActivityStudentsBinding

class StudentsActivity : AppCompatActivity() {
    private val binding by lazy { ActivityStudentsBinding.inflate(layoutInflater) }
    private val adapter by lazy {  StudentsViewPagerAdapter(this) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.pager.adapter = adapter
    }
}