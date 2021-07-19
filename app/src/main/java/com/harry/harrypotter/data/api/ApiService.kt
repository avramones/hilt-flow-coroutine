package com.harry.harrypotter.data.api

import com.harry.harrypotter.model.Person
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Path

interface ApiService {

    @Headers("Content-Type: application/json")
    @GET("characters/house/{house}")
    suspend fun loadCharacters(@Path("house") house: String?): List<Person>?
}