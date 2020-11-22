package com.example.omdbfilms.domain.di

import com.example.omdbfilms.domain.model.SearchModel
import com.example.omdbfilms.domain.model.DefaultSearchModel
import dagger.Binds
import dagger.Module

@Module
abstract class ModelModule {

    @Binds
    abstract fun bindSearchModel(model: DefaultSearchModel): SearchModel
}
