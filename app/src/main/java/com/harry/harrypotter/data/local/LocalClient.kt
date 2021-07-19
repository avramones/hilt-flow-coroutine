package com.harry.harrypotter.data.local

import com.harry.harrypotter.model.Person
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class LocalClient @Inject constructor(
    private val dataBase: CharacterDataBase
) {

    suspend fun getAllCharacters(house: String?): Flow<List<Person>?> {
        return flow {
            val response = dataBase.characterDao()?.loadAllCharacters(house)
            emit(response)
        }
    }

    suspend fun insertAll(people: List<Person>?) {
        dataBase.characterDao()?.insertAll(people)
    }

}
