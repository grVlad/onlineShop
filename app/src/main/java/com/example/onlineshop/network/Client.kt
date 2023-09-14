package com.example.onlineshop.network

import io.ktor.client.HttpClient
import io.ktor.client.engine.android.Android
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.serialization.kotlinx.json.json

const val HOST = "https://fakestoreapi.com/"

class ClientProvider {

    val client = HttpClient(Android) {
        install(ContentNegotiation) {
            json()
        }
    }
}

