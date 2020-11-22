package com.example.omdbapi.di

import com.example.omdbapi.retrofit.OmdbApiFactory
import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.core.JsonParser
import com.fasterxml.jackson.databind.DeserializationFeature
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.databind.module.SimpleModule
import com.fasterxml.jackson.module.kotlin.KotlinModule
import dagger.Module
import dagger.Provides
import hu.akarnokd.rxjava3.retrofit.RxJava3CallAdapterFactory
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.jackson.JacksonConverterFactory

@Module
class NetworkModule {

    @Provides
    fun provideOkHttpClient(): OkHttpClient {
        val apiKey = "55847347"
        val apiKeyInterseptor = Interceptor { chain ->
            val newUrl = chain
                .request()
                .url
                .newBuilder()
                .addQueryParameter("apikey", apiKey)
                .build()

            val newRequest = chain
                .request()
                .newBuilder()
                .url(newUrl)
                .build()

            chain.proceed(newRequest)
        }

        return OkHttpClient()
            .newBuilder()
            .addInterceptor(apiKeyInterseptor)
            .build()
    }

    @Provides
    fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit {
        val objectMapper: ObjectMapper =
            ObjectMapper()
                .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
                .configure(JsonParser.Feature.ALLOW_TRAILING_COMMA, true)
                .setSerializationInclusion(JsonInclude.Include.NON_NULL)
                .registerModule(SimpleModule())
                .registerModule(KotlinModule())

        return Retrofit.Builder()
            .client(okHttpClient)
            .baseUrl("https://www.omdbapi.com/")
            .addConverterFactory(JacksonConverterFactory.create(objectMapper))
//        .addCallAdapterFactory(CoroutineCallAdapterFactory())
            .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
            .build()
    }
}
