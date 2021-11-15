package com.udacity.shoestore.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentInstructionBinding

class InstructionFragment : Fragment() {

    lateinit var  binding: FragmentInstructionBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentInstructionBinding.inflate(inflater, container , false);
        // Inflate the layout for this fragment

        binding.instructionsBtn.setOnClickListener{
            this.findNavController().navigate(R.id.action_instructionsFragment_to_shoeListFragment)
        }

        return binding.root
    }
}