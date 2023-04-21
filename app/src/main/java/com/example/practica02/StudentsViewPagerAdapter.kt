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
        // Return a NEW fragment instance in createFragment(int)
        val fragment = StudentsFragment()
        fragment.arguments = Bundle().apply {
            // Our object is just an integer :-P
            putInt(ARG_OBJECT, position + 1)
        }
        return fragment
    }
}