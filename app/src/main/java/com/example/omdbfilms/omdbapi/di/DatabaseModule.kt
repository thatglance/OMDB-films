package com.example.omdbfilms.omdbapi.di

import android.app.Application
import androidx.room.Room
import com.example.omdbfilms.omdbapi.db.FilmsDao
import com.example.omdbfilms.omdbapi.db.FilmsDatabase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DatabaseModule {

    @Singleton
    @Provides
    fun provideDatabase(app: Application): FilmsDatabase {
        return Room
            .databaseBuilder(app, FilmsDatabase::class.java, "films_database")
            .build()
    }

    @Singleton
    @Provides
    fun provideDao(db: FilmsDatabase): FilmsDao {
        return db.filmsDao()
    }
}
