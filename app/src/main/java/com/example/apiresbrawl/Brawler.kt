package com.example.apiresbrawl

data class Brawler(
    val id: String,
    val name: String,
    val description: String,
    val category: String,
    val type: String,
    val rarity: String,
    val health: Int,
    val speed: Double,
    val imageUrl: String
)
