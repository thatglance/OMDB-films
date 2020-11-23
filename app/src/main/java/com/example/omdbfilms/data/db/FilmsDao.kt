package com.example.omdbfilms.data.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Single

@Dao
interface FilmsDao {

    @Query("SELECT * from films_table WHERE title LIKE '%' || :searchString || '%'")
    fun getFilms(searchString: String): Single<List<FilmDetailsRoomEntity>>

    @Query("SELECT * from films_table")
    fun getAllFilms(): Single<List<FilmDetailsRoomEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(films: List<FilmDetailsRoomEntity>): Completable

    @Query("DELETE from films_table")
    fun deleteAll(): Completable
}
