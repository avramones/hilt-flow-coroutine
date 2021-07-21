package com.harry.harrypotter.ui.main.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.harry.harrypotter.R
import com.harry.harrypotter.databinding.FragmentWandBinding
import com.harry.harrypotter.ui.base.BaseFragment
import com.harry.harrypotter.ui.main.vm.MainViewModel2
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class WandFragment : BaseFragment<FragmentWandBinding>() {

    override fun getViewBinding() = FragmentWandBinding.inflate(layoutInflater)

    override fun init() {

    }
}