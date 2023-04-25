package com.example.practica02

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter

class StudentsViewPagerAdapter (fragment: FragmentActivity) : FragmentStateAdapter(fragment) {
    companion object{
        private const val ARG_OBJECT = "object"
    }

    override fun getItemCount(): Int = 13

    override fun createFragment(position: Int): Fragment {
        val fragment = StudentsFragment()
        fragment.arguments = Bundle().apply {
            putInt(ARG_OBJECT, position)
        }
        return fragment
    }
}