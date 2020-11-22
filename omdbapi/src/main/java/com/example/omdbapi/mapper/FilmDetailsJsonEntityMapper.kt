package com.example.omdbapi.mapper

import com.example.domain.common.Mapper
import com.example.domain.entity.FilmDetails
import com.example.omdbapi.entity.FilmDetailsJson
import javax.inject.Inject

class FilmDetailsJsonEntityMapper @Inject constructor(): Mapper<List<FilmDetailsJson>, List<FilmDetails>> {

    override fun map(from: List<FilmDetailsJson>): List<FilmDetails> {
        return from.map {
            FilmDetails(
                imdbID = it.imdbID,
                title = it.title,
                year = it.year,
                type = it.type,
                genre = it.genre,
                plot = it.plot
            )
        }
    }
}
