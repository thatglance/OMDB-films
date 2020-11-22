package com.example.omdbfilms.domain.model

import com.example.omdbfilms.domain.entity.FilmDetails
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Single

interface SearchModel {
    fun getFilms(searchString: String): Single<List<FilmDetails>?>
    fun getCachedFilms(): Single<List<FilmDetails>?>
    fun clearCache(): Completable
}
