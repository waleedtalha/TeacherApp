package com.cwise.teacherappkotlin

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.cwise.teacherappkotlin.activities.PresentRecActivity
import com.cwise.teacherappkotlin.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(inflater, container, false)

        binding.btnPresentRec.setOnClickListener {
            startActivity(Intent(context, PresentRecActivity::class.java))
        }
        return binding.root
    }

}