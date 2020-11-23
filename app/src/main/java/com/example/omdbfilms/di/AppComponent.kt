package com.example.omdbfilms.di

import android.app.Application
import com.example.omdbfilms.data.di.ApiModule
import com.example.omdbfilms.data.di.NetworkModule
import com.example.omdbfilms.domain.di.InteractorModule
import com.example.omdbfilms.data.di.DatabaseModule
import com.example.omdbfilms.data.di.RepositoryModule
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
        InteractorModule::class,
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
