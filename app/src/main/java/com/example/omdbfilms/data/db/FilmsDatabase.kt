package com.example.omdbfilms.data.db

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [FilmDetailsRoomEntity::class], version = 1, exportSchema = false)
abstract class FilmsDatabase : RoomDatabase() {

    abstract fun filmsDao(): FilmsDao
}
