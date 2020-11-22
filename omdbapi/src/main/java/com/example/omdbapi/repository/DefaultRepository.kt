package com.example.omdbapi.repository

import com.example.domain.common.Mapper
import com.example.domain.entity.FilmDetails
import com.example.domain.repository.Repository
import com.example.omdbapi.entity.FilmDetailsJson
import com.example.omdbapi.mapper.FilmDetailsJsonEntityMapper
import com.example.omdbapi.retrofit.OmdbApiFactory
import com.example.omdbapi.retrofit.OmdbApiService
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.schedulers.Schedulers
import javax.inject.Inject

class DefaultRepository @Inject constructor(
    private val omdbApiService: OmdbApiService,
    private var mapper: Mapper<List<FilmDetailsJson>, List<FilmDetails>>
): Repository {

//    private val omdbApiService = OmdbApiFactory.omdbApiService
//    private val mapper: Mapper<List<FilmDetailsJson>, List<FilmDetails>> =
    //TODO: remove!
//    init {
//        mapper = FilmDetailsJsonEntityMapper()
//    }

    override fun getFilms(searchString: String): Observable<List<FilmDetails>> {
        return omdbApiService.getFilmsRx(searchString)
            .subscribeOn(Schedulers.io())
            .map {searchResult ->
                searchResult.search?.let {
                    mapper.map(it)
                }
            }
    }
}
