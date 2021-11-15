package com.udacity.shoestore.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentShoeDetailBinding
import com.udacity.shoestore.models.Shoe

class ShoeDetailFragment : Fragment() {


    private lateinit var binding: FragmentShoeDetailBinding

    private val viewModel by lazy {
        ViewModelProvider(requireActivity())[ShoeViewModel::class.java]
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentShoeDetailBinding.inflate(inflater, container , false);


        binding.shoeDetailCancelBTN.setOnClickListener{
            it.findNavController().navigate(R.id.action_shoeDetailFragment_to_shoeListFragment)
        }
        binding.shoe = Shoe()
        binding.shoeDetailSaveBTN.setOnClickListener{
            viewModel.addShoe(binding.shoe!!)
            it.findNavController().navigate(R.id.action_shoeDetailFragment_to_shoeListFragment)

        }

        return binding.root
    }




}