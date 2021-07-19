package com.harry.harrypotter.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.RecyclerView
import com.harry.harrypotter.R
import com.harry.harrypotter.model.Person
import com.harry.harrypotter.ui.adapter.PersonAdapter
import com.harry.harrypotter.ui.vm.MainViewModel2
import com.harry.harrypotter.utils.AppConstants
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

@AndroidEntryPoint
class PersonFragment : Fragment() {
    private lateinit var recyclerView: RecyclerView
    private val viewModel: MainViewModel2 by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_person, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyclerView = view.findViewById(R.id.recycler_view)
        if (arguments != null && requireArguments().containsKey(AppConstants.HOUSE)) {
            viewModel.loadAllCharacters(requireArguments().getString(AppConstants.HOUSE))

            lifecycleScope.launch {
                viewModel.characterData.collect {
                    initRecyclerView(it)
                }
            }

        }
    }

    private fun initRecyclerView(personList: List<Person>) {
        val adapter = PersonAdapter(context, personList)
        recyclerView.adapter = adapter
        adapter.setOnItemClickListener { _: View?, _: Int -> }
    }
}


