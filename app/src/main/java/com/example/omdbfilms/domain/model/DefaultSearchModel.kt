package com.example.omdbfilms.domain.model

import com.example.omdbfilms.domain.entity.FilmDetails
import com.example.omdbfilms.domain.repository.Repository
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.schedulers.Schedulers
import javax.inject.Inject

class DefaultSearchModel @Inject constructor(private val repo: Repository) : SearchModel {

    override fun getFilms(searchString: String): Single<List<FilmDetails>?> {
        return repo.getFilms(searchString)
            .onErrorResumeNext {
                repo.getCachedFilms(searchString)
            }
            .subscribeOn(Schedulers.io())
    }

    override fun getCachedFilms(): Single<List<FilmDetails>?> {
        return repo.getAllCachedFilms()
            .subscribeOn(Schedulers.io())
    }

    override fun clearCache(): Completable {
        return repo.clearCache()
            .subscribeOn(Schedulers.io())
    }
}
