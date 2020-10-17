package com.example.omdbfilms.model

import com.example.omdbapi.retrofit.OmdbApiFactory

class SearchModel {
    private val omdbApiService = OmdbApiFactory.omdbApiService

    suspend fun getFilms(searchString: String) = omdbApiService.getFilms(searchString)

}