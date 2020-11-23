package com.example.omdbfilms.domain.di

import com.example.omdbfilms.domain.interactor.SearchInteractor
import com.example.omdbfilms.domain.interactor.DefaultSearchInteractor
import dagger.Binds
import dagger.Module

@Module
abstract class InteractorModule {

    @Binds
    abstract fun bindSearchInteractor(interactor: DefaultSearchInteractor): SearchInteractor
}
