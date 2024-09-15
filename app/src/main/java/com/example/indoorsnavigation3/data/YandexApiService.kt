package com.example.indoorsnavigation3.data

import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

interface YandexApiService {
    @GET("v3.0/search/")
    fun getTransportSchedule(
        @Query("apikey") apikey: String,
        @Query("from") from: String,
        @Query("to") to: String,
        @Query("date") date: String,
        @Query("format") format: String = "json",
        @Query("lang") lang: String = "ru_RU",
        @Query("transport_types") transportTypes: String? = null
    ): Call<TransportResponse>
}
