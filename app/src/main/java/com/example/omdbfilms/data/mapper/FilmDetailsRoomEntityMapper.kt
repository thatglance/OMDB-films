package com.example.omdbfilms.data.mapper

import com.example.omdbfilms.domain.common.Mapper
import com.example.omdbfilms.domain.entity.FilmDetails
import com.example.omdbfilms.data.db.FilmDetailsRoomEntity

class FilmDetailsRoomEntityMapper : Mapper<List<FilmDetailsRoomEntity>, List<FilmDetails>> {

    override fun map(from: List<FilmDetailsRoomEntity>): List<FilmDetails> {
        return from.map { film ->
            FilmDetails(
                film.title,
                film.year,
                film.type
            )
        }
    }
}
