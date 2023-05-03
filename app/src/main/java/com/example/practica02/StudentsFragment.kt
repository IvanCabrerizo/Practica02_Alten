package com.example.practica02

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.example.practica02.databinding.FragmentStudentsBinding

class StudentsFragment : Fragment() {
    private val binding by lazy { FragmentStudentsBinding.inflate(layoutInflater) }

    companion object {
        private const val ARG_OBJECT = "object"
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        arguments?.takeIf { it.containsKey(ARG_OBJECT) }?.apply {
            injectData(getInt(ARG_OBJECT))
        }
    }

    private fun injectData(position: Int) {
        binding.fragmentStudentLabelName.text = studentList[position].name
        binding.fragmentStudentLabelLastName.text = studentList[position].surname
        binding.fragmentStudentLabelMail.text = studentList[position].mail
        binding.fragmentStudentLabelCity.text = studentList[position].city
        binding.fragmentStudentLabelStudyCenter.text = studentList[position].studyCenter
        binding.fragmentStudentImgAvatar.glideUrl(studentList[position].photo)
        binding.fragmentStudentLabelTutorName.text = getTutorData(studentList[position].tutorId)
    }

    private fun getTutorData(tutorId: Int): String {
        return (tutorList.find { it.id == tutorId }?.name
            ?: "") + " " + (tutorList.find { it.id == tutorId }?.surname
            ?: "")
    }
}