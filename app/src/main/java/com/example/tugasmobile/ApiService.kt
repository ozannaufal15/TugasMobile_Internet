package com.example.tugasmobile

import retrofit2.http.GET

interface ApiService {
        @GET("random_ten")
        suspend fun getJokes(): List<DataModel>
}
