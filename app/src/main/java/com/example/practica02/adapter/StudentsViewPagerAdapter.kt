package com.example.practica02.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.practica02.StudentsFragment
import com.example.practica02.model.Person

class StudentsViewPagerAdapter(
    private val studentList: List<Person.Student>,
    fragment: FragmentActivity
) :
    FragmentStateAdapter(fragment) {

    override fun getItemCount() = studentList.size

    override fun createFragment(position: Int): Fragment {
        return StudentsFragment.newFragment(position)
    }
}