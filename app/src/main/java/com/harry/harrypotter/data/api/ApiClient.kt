package com.harry.harrypotter.data.api

import com.harry.harrypotter.model.Person
import com.harry.harrypotter.utils.AppConstants
import io.reactivex.Observable
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ApiClient @Inject constructor() {

    private val apiService: ApiService

    suspend fun loadCharacters(house: String?): Flow<List<Person>?> {
        return flow { emit(apiService.loadCharacters(house)) }
    }

    init {
        val logging = HttpLoggingInterceptor()
        logging.level = HttpLoggingInterceptor.Level.BODY
        val client = OkHttpClient.Builder().addInterceptor(logging).build()
        val retrofit = Retrofit.Builder()
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create()).client(client)
            .baseUrl(AppConstants.BASE_URL).build()
        apiService = retrofit.create(ApiService::class.java)
    }
}