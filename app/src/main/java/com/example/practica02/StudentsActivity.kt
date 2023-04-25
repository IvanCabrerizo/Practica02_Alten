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

        binding.pager.adapter = adapter
        val tabLayoutMediator = TabLayoutMediator(binding.tabLayout, binding.pager,
            TabLayoutMediator.TabConfigurationStrategy { tab, position ->
                tab.text = position.toString()
            })
        tabLayoutMediator.attach()
    }
}