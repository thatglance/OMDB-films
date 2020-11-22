package com.example.omdbapi.retrofit

import com.example.omdbapi.entity.FilmDetailsJson
import com.example.omdbapi.entity.SearchResultJson
import io.reactivex.rxjava3.core.Observable
import kotlinx.coroutines.Deferred
import retrofit2.http.GET
import retrofit2.http.Query

interface OmdbApiService {

    //https://www.omdbapi.com/?apikey=55847347
    @GET(".")
    suspend fun getFilms(
        @Query("s") searchString: String = ""
    ): SearchResultJson

    @GET(".")
    fun getFilmsAsync(
        @Query("s") searchString: String = ""
    ): Deferred<SearchResultJson>

    @GET(".")
    fun getFilm(
        @Query("i") id: String = ""
    ): Deferred<FilmDetailsJson>

    @GET(".")
    fun getFilmsRx(
        @Query("s") searchString: String = ""
    ): Observable<SearchResultJson>
}
