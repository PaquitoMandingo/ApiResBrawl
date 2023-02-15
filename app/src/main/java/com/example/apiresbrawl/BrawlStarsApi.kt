package com.example.apiresbrawl

import retrofit2.http.GET
import retrofit2.http.Header

interface BrawlStarsApi {
    @GET("v1/brawlers")
    suspend fun getBrawlers(
        @Header("Authorization") token: String
    ): List<Brawler>
}

