package com.example.practica02

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.example.practica02.databinding.FragmentStudentsBinding
import com.example.practica02.model.Person
import com.example.practica02.repository.studentList

class StudentsFragment : Fragment() {
    private val binding by lazy { FragmentStudentsBinding.inflate(layoutInflater) }

    companion object {
        private const val ARG_POSITION = "studentPosition"

        fun newFragment(position: Int): StudentsFragment {
            val fragment = StudentsFragment()
            fragment.arguments = Bundle().apply {
                putInt(ARG_POSITION, position)
            }
            return fragment
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
//        val position: Int = arguments?.getInt(ARG_POSITION, -1)?: -1
        arguments?.takeIf { it.containsKey(ARG_POSITION) }?.apply {
            binding.renderStudent(studentList[getInt(ARG_POSITION)])
        }
    }

    private fun FragmentStudentsBinding.renderStudent(student: Person.Student) {
        with(student) {
            fragmentStudentImgAvatar.imageUrl(photo)
            studentInfo.fragmentStudentLabelName.text = name
            studentInfo.fragmentStudentLabelLastName.text = surname
            studentInfo.fragmentStudentLabelMail.text = mail
            studentInfo.fragmentStudentLabelCity.text = city
            studentInfo.fragmentStudentLabelStudyCenter.text = studyCenter
            studentInfo.fragmentStudentLabelTutorName.text = "${tutor?.name} ${tutor?.surname}"
        }
    }
}