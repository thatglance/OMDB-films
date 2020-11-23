package com.example.omdbfilms.data.di

import android.app.Application
import androidx.room.Room
import com.example.omdbfilms.data.db.FilmsDao
import com.example.omdbfilms.data.db.FilmsDatabase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

private const val DB_NAME = "films_database"

@Module
class DatabaseModule {

    @Singleton
    @Provides
    fun provideDatabase(app: Application): FilmsDatabase {
        return Room
            .databaseBuilder(app, FilmsDatabase::class.java, DB_NAME)
            .build()
    }

    @Singleton
    @Provides
    fun provideDao(db: FilmsDatabase): FilmsDao {
        return db.filmsDao()
    }
}
