package com.example.omdbfilms.domain.repository

import com.example.omdbfilms.domain.entity.FilmDetails
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Single

interface Repository {
    fun getFilms(searchString: String): Single<List<FilmDetails>?>
    fun getCachedFilms(searchString: String): Single<List<FilmDetails>?>
    fun getAllCachedFilms(): Single<List<FilmDetails>?>
    fun saveToCache(films: List<FilmDetails>): Completable
    fun clearCache(): Completable
}
