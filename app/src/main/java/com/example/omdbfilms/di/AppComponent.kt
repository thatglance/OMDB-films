package com.example.omdbfilms.di

import android.app.Application
import com.example.omdbfilms.omdbapi.di.ApiModule
import com.example.omdbfilms.omdbapi.di.NetworkModule
import com.example.omdbfilms.domain.di.ModelModule
import com.example.omdbfilms.omdbapi.di.DatabaseModule
import com.example.omdbfilms.omdbapi.di.RepositoryModule
import com.example.omdbfilms.view.SearchFragment
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        NetworkModule::class,
        ApiModule::class,
        DatabaseModule::class,
        RepositoryModule::class,
        ModelModule::class,
        ViewModelModule::class
    ]
)
interface AppComponent {

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun bindApplication(app: Application): Builder

        fun build(): AppComponent
    }

    fun inject(fragment: SearchFragment)
}
