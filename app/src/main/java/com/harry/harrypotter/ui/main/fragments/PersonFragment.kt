package com.harry.harrypotter.ui.main.fragments

import androidx.core.view.isVisible
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.lifecycleScope
import com.harry.harrypotter.databinding.FragmentPersonBinding
import com.harry.harrypotter.ui.base.BaseFragment
import com.harry.harrypotter.ui.main.adapter.PersonAdapter
import com.harry.harrypotter.ui.main.vm.MainViewModel2
import com.harry.harrypotter.utils.AppConstants
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.drop

@AndroidEntryPoint
class PersonFragment : BaseFragment<FragmentPersonBinding>() {

    override fun getViewBinding() = FragmentPersonBinding.inflate(layoutInflater)
    private val viewModel: MainViewModel2 by activityViewModels()
    private val personAdapter = PersonAdapter()

    override fun init() {

        binding.recyclerView.adapter = personAdapter

        arguments?.getString(AppConstants.HOUSE)?.let {
            viewModel.loadAllCharacters(it)
        }

        lifecycleScope.launchWhenStarted {
            viewModel.characterData
                .drop(1)
                .collect {
                   personAdapter.setData(it)
                }
        }

        lifecycleScope.launchWhenStarted {
            viewModel.loading
                .collect {
                    binding.progress.isVisible = it
                }
        }
    }
}


