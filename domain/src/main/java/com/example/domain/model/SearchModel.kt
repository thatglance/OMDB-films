package com.example.domain.model

import com.example.domain.repository.Repository
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.schedulers.Schedulers
import javax.inject.Inject

class SearchModel @Inject constructor(private val repo: Repository) : ISearchModel {
//    private val omdbApiService = OmdbApiFactory.omdbApiService

//    override suspend fun getFilms(searchString: String) = omdbApiService.getFilms(searchString)

//    private val repo: Repository = DefaultRepository()
//    override fun getFilmsRx(searchString: String): Observable<SearchResultJson> {
//        return omdbApiService.getFilmsRx(searchString).subscribeOn(Schedulers.io())
//    }
}