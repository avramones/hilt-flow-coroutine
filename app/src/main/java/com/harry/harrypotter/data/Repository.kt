package com.harry.harrypotter.data

import com.harry.harrypotter.data.api.ApiClient
import com.harry.harrypotter.data.local.LocalClient
import com.harry.harrypotter.model.Person
import com.harry.harrypotter.utils.NetworkUtils
import com.harry.harrypotter.utils.Utils
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class Repository @Inject constructor(
    private val apiClient: ApiClient,
    private val localClient: LocalClient,
    private val networkUtils: NetworkUtils
) {

    fun loadCharacters(house: String?) =
        if (networkUtils.isNetworkAvailable()) {
            apiClient.loadCharacters(house)
        } else localClient.getAllCharacters(Utils.capitalize(house))


    suspend fun insertCharacters(people: List<Person>?) {
        localClient.insertAll(people)
    }
}