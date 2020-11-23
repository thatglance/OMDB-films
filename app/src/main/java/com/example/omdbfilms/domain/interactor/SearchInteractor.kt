package com.example.omdbfilms.domain.interactor

import com.example.omdbfilms.domain.entity.FilmDetails
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Single

interface SearchInteractor {
    fun getFilms(searchString: String): Single<List<FilmDetails>?>
    fun getCachedFilms(): Single<List<FilmDetails>?>
    fun clearCache(): Completable
}
