package com.example.omdbapi.di

import com.example.domain.common.Mapper
import com.example.domain.entity.FilmDetails
import com.example.omdbapi.entity.FilmDetailsJson
import com.example.omdbapi.mapper.FilmDetailsJsonEntityMapper
import dagger.Binds
import dagger.Module
import dagger.Provides

@Module
class RepositoryModule {

    @Provides
    fun bindFilmDetailsJsonEntityMapper(): Mapper<List<FilmDetailsJson>, List<FilmDetails>> {
        return FilmDetailsJsonEntityMapper()
    }
}
//TODO: maybe need to add @Qualifier for bind method?