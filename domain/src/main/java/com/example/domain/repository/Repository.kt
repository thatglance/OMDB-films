package com.example.domain.repository

import com.example.domain.entity.FilmDetails
import io.reactivex.rxjava3.core.Observable

interface Repository {
    fun getFilms(searchString: String): Observable<List<FilmDetails>>
}
