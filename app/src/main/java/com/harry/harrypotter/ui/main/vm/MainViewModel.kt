package com.harry.harrypotter.ui.main.vm

import android.annotation.SuppressLint
import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.harry.harrypotter.data.Repository
import com.harry.harrypotter.model.Person
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

@SuppressLint("CheckResult")
@HiltViewModel
class MainViewModel2 @Inject constructor(
    private val repository: Repository
) : ViewModel() {

    private val _characterData = MutableStateFlow(ArrayList<Person>())
    val characterData: StateFlow<List<Person>> = _characterData.asStateFlow()

    private val _loading = MutableStateFlow(true)
    val loading: StateFlow<Boolean> = _loading.asStateFlow()

    fun loadAllCharacters(house: String?) {
        viewModelScope.launch {
            _loading.value = true
            repository.loadCharacters(house)
                .catch { error ->
                    Log.d("FAIL:", error.message.toString())
                }
                .collect { list ->
                    _loading.value = false
                    _characterData.value = list as ArrayList<Person>
                    repository.insertCharacters(list)
                }
        }
    }

}