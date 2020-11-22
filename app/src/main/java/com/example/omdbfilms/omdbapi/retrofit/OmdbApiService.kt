package com.example.omdbfilms.omdbapi.retrofit

import com.example.omdbfilms.omdbapi.entity.SearchResultJson
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface OmdbApiService {

    // https://www.omdbapi.com/?apikey=55847347&s=searchString
    @GET(".")
    fun getFilms(
        @Query("s") searchString: String = ""
    ): Single<SearchResultJson>
}
