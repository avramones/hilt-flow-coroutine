package com.harry.harrypotter.ui.main.fragments

import android.view.View
import androidx.core.os.bundleOf
import androidx.navigation.fragment.findNavController
import com.harry.harrypotter.R
import com.harry.harrypotter.databinding.FragmentHomeBinding
import com.harry.harrypotter.ui.base.BaseFragment
import com.harry.harrypotter.utils.AppConstants
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : BaseFragment<FragmentHomeBinding>(), View.OnClickListener {

    override fun getViewBinding() = FragmentHomeBinding.inflate(layoutInflater)

    override fun init() {
       binding.button1.setOnClickListener(this)
       binding.button2.setOnClickListener(this)
       binding.button3.setOnClickListener(this)
       binding.button4.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        val house = when (v.id) {
            R.id.button_1 -> AppConstants.GRYFFINDOR
            R.id.button_2 -> AppConstants.HUFFLEPUFF
            R.id.button_3 -> AppConstants.RAVENCLAW
            R.id.button_4 -> AppConstants.SLYTHERIN
            else -> ""
        }
        val bundle = bundleOf(AppConstants.HOUSE to house)
        findNavController()
            .navigate(R.id.action_homeFragment_to_personFragment, bundle)
    }

}