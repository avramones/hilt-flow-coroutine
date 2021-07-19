package com.harry.harrypotter.ui.vm

import android.annotation.SuppressLint
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.harry.harrypotter.data.Repository
import com.harry.harrypotter.model.Person
import dagger.hilt.android.lifecycle.HiltViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import okhttp3.Dispatcher
import javax.inject.Inject

@SuppressLint("CheckResult")
@HiltViewModel
class MainViewModel2 @Inject constructor(
    private val repository: Repository)
    : ViewModel() {

    private val _characterData = MutableStateFlow(ArrayList<Person>())
    val characterData : StateFlow<List<Person>> = _characterData

    fun loadAllCharacters(house: String?) {
        viewModelScope.launch {
             repository.loadCharacters(house)
                .collect {
                    _characterData.value = it as ArrayList<Person>
                    repository.insertCharacters(it)
                }
        }
    }
}