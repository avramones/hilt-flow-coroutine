package com.harry.harrypotter.data.local

import com.harry.harrypotter.model.Person
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class LocalClient @Inject constructor(
    private val dataBase: CharacterDataBase
) {

    fun getAllCharacters(house: String?) = flow {
            val response = dataBase.characterDao()
                ?.loadAllCharacters(house)
            emit(response)
        }.flowOn(Dispatchers.IO)


    suspend fun insertAll(people: List<Person>?) {
        dataBase.characterDao()?.insertAll(people)
    }

}
