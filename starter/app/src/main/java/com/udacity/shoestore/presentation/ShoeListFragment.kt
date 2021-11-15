package com.udacity.shoestore.presentation

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.NavigationUI
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentShoeListBinding
import com.udacity.shoestore.databinding.ShoeItemBinding
import com.udacity.shoestore.models.Shoe

class ShoeListFragment : Fragment() {

    lateinit var  binding: FragmentShoeListBinding

    private val viewModel by lazy {
        ViewModelProvider(requireActivity())[ShoeViewModel::class.java]
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentShoeListBinding.inflate(inflater, container , false);

        viewModel.shoeLiveData.observe(viewLifecycleOwner) { shoes ->
            binding.shoesLL.removeAllViews()

            for (shoe in shoes) {
                addShoe(shoe)
            }

        }
        setHasOptionsMenu(true)



        binding.addShoeFab.setOnClickListener {
            this.findNavController().navigate(R.id.action_shoeListFragment_to_shoeDetailFragment)
        }
        return binding.root
    }



    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return NavigationUI.onNavDestinationSelected(item, requireView().findNavController()) || super.onOptionsItemSelected(item)
    }

    private fun addShoe(shoe: Shoe) {
        val shoeView = View.inflate(context, R.layout.shoe_item, null)
        val shoeBinding = ShoeItemBinding.bind(shoeView)
        shoeBinding.shoe = shoe
        binding.shoesLL.addView(shoeView)
    }

}