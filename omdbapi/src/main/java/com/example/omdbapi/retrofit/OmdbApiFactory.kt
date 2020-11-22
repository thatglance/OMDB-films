package com.example.omdbapi.retrofit

import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.core.JsonParser
import com.fasterxml.jackson.databind.DeserializationFeature
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.databind.module.SimpleModule
import com.fasterxml.jackson.module.kotlin.KotlinModule
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import hu.akarnokd.rxjava3.retrofit.RxJava3CallAdapterFactory
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.jackson.JacksonConverterFactory

object OmdbApiFactory {
    private const val API_KEY = "55847347"

    private val apiKeyInterseptor = Interceptor { chain ->
        val newUrl = chain
            .request()
            .url
            .newBuilder()
            .addQueryParameter("apikey", API_KEY)
            .build()

        val newRequest = chain
            .request()
            .newBuilder()
            .url(newUrl)
            .build()

        chain.proceed(newRequest)
    }

    private val okHttpClient = OkHttpClient()
        .newBuilder()
        .addInterceptor(apiKeyInterseptor)
        .build()

    private val objectMapper: ObjectMapper =
        ObjectMapper()
            .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
            .configure(JsonParser.Feature.ALLOW_TRAILING_COMMA, true)
            .setSerializationInclusion(JsonInclude.Include.NON_NULL)
            .registerModule(SimpleModule())
            .registerModule(KotlinModule())

    private fun createRetrofit(): Retrofit = Retrofit.Builder()
        .client(okHttpClient)
        .baseUrl("https://www.omdbapi.com/")
        .addConverterFactory(JacksonConverterFactory.create(objectMapper))
//        .addCallAdapterFactory(CoroutineCallAdapterFactory())
        .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
        .build()

    val omdbApiService: OmdbApiService = createRetrofit().create(OmdbApiService::class.java)
}
