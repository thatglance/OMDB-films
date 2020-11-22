package com.example.omdbapi.di

import com.example.omdbapi.retrofit.OmdbApiService
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit

@Module(includes = [NetworkModule::class])
class ApiModule {

    @Provides
    fun provideOmdbApiService(retrofit: Retrofit): OmdbApiService {
        return retrofit.create(OmdbApiService::class.java)
    }
}
