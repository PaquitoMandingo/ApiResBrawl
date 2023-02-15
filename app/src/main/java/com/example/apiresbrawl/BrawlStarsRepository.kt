package com.example.apiresbrawl

class BrawlStarsRepository {
    private val api: BrawlStarsApi

    init {
        // Crea una instancia de Retrofit
        val retrofit = Retrofit.Builder()
            .baseUrl("https://api.brawlstars.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        // Crea una instancia de la interfaz BrawlStarsApi
        api = retrofit.create(BrawlStarsApi::class.java)
    }

    suspend fun getBrawlers(token: String): List<Brawler> {
        // Llama a la función getBrawlers de la API con el token de autenticación
        return api.getBrawlers("Bearer $token")
    }
}
