package com.example.omdbfilms.omdbapi.di

import com.example.omdbfilms.domain.common.Mapper
import com.example.omdbfilms.domain.entity.FilmDetails
import com.example.omdbfilms.omdbapi.entity.SearchResultJson
import com.example.omdbfilms.omdbapi.mapper.SearchResultJsonFilmDetailsMapper
import com.example.omdbfilms.omdbapi.retrofit.OmdbApiService
import com.example.omdbfilms.domain.repository.Repository
import com.example.omdbfilms.omdbapi.db.FilmDetailsRoomEntity
import com.example.omdbfilms.omdbapi.db.FilmsDao
import com.example.omdbfilms.omdbapi.mapper.FilmDetailsEntityRoomMapper
import com.example.omdbfilms.omdbapi.mapper.FilmDetailsRoomEntityMapper
import com.example.omdbfilms.omdbapi.repository.DefaultRepository
import dagger.Module
import dagger.Provides

@Module(includes = [ApiModule::class])
class RepositoryModule {

    @Provides
    fun provideFilmDetailsJsonEntityMapper(): Mapper<SearchResultJson, List<FilmDetails>> {
        return SearchResultJsonFilmDetailsMapper()
    }

    @Provides
    fun provideFilmDetailsRoomEntityMapper(): Mapper<List<FilmDetailsRoomEntity>, List<FilmDetails>> {
        return FilmDetailsRoomEntityMapper()
    }

    @Provides
    fun provideFilmDetailsEntityRoomMapper(): Mapper<List<FilmDetails>, List<FilmDetailsRoomEntity>> {
        return FilmDetailsEntityRoomMapper()
    }

    @Provides
    fun provideRepository(
        apiService: OmdbApiService,
        dao: FilmsDao,
        searchResultJsonMapper: Mapper<SearchResultJson, List<FilmDetails>>,
        roomEntityMapper: Mapper<List<FilmDetailsRoomEntity>, List<FilmDetails>>,
        entityRoomMapper: Mapper<List<FilmDetails>, List<FilmDetailsRoomEntity>>
    ): Repository {
        return DefaultRepository(
            apiService,
            dao,
            searchResultJsonMapper,
            roomEntityMapper,
            entityRoomMapper
        )
    }
}
