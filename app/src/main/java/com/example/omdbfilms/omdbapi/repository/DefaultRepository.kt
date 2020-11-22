package com.example.omdbfilms.omdbapi.repository

import com.example.omdbfilms.domain.common.Mapper
import com.example.omdbfilms.domain.entity.FilmDetails
import com.example.omdbfilms.domain.repository.Repository
import com.example.omdbfilms.omdbapi.entity.SearchResultJson
import com.example.omdbfilms.omdbapi.retrofit.OmdbApiService
import com.example.omdbfilms.omdbapi.db.FilmDetailsRoomEntity
import com.example.omdbfilms.omdbapi.db.FilmsDao
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject

class DefaultRepository @Inject constructor(
    private val omdbApiService: OmdbApiService,
    private val dao: FilmsDao,
    private val searchResultJsonMapper: Mapper<SearchResultJson, List<FilmDetails>>,
    private val roomEntityMapper: Mapper<List<FilmDetailsRoomEntity>, List<FilmDetails>>,
    private val entityRoomMapper: Mapper<List<FilmDetails>, List<FilmDetailsRoomEntity>>
) : Repository {

    override fun getFilms(searchString: String): Single<List<FilmDetails>?> {
        return omdbApiService.getFilms(searchString)
            .flatMap {
                saveToCache(searchResultJsonMapper.map(it))
                    .andThen(
                        getCachedFilms(searchString)
                    )
            }
    }

    override fun getCachedFilms(searchString: String): Single<List<FilmDetails>?> {
        return dao.getFilms(searchString)
            .map {
                roomEntityMapper.map(it)
            }
    }

    override fun getAllCachedFilms(): Single<List<FilmDetails>?> {
        return dao.getAllFilms()
            .map {
                roomEntityMapper.map(it)
            }
    }

    override fun saveToCache(films: List<FilmDetails>): Completable {
        return dao.insertAll(
            entityRoomMapper.map(films)
        )
    }

    override fun clearCache(): Completable {
        return dao.deleteAll()
    }
}
