package com.udacity.shoestore.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentWelcomeBinding

class WelcomeFragment : Fragment() {

    lateinit var  binding: FragmentWelcomeBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentWelcomeBinding.inflate(inflater, container , false);
        // Inflate the layout for this fragment

        binding.welcomeBtn.setOnClickListener{
            this.findNavController().navigate(R.id.action_welcomeFragment_to_instructionsFragment)
        }

        return binding.root
    }

}