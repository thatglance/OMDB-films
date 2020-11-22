package com.example.omdbfilms.omdbapi.mapper

import com.example.omdbfilms.domain.common.Mapper
import com.example.omdbfilms.domain.entity.FilmDetails
import com.example.omdbfilms.omdbapi.db.FilmDetailsRoomEntity

class FilmDetailsEntityRoomMapper : Mapper<List<FilmDetails>, List<FilmDetailsRoomEntity>> {

    override fun map(from: List<FilmDetails>): List<FilmDetailsRoomEntity> {
        return from.map {
            FilmDetailsRoomEntity(
                title = it.title,
                year = it.year,
                type = it.type
            )
        }
    }
}
