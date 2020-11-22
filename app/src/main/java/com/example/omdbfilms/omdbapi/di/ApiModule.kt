package com.example.omdbfilms.omdbapi.di

import com.example.omdbfilms.omdbapi.retrofit.OmdbApiService
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
