package com.example.omdbfilms.data.mapper

import com.example.omdbfilms.domain.common.Mapper
import com.example.omdbfilms.domain.entity.FilmDetails
import com.example.omdbfilms.data.entity.SearchResultJson

class SearchResultJsonFilmDetailsMapper : Mapper<SearchResultJson, List<FilmDetails>> {

    override fun map(from: SearchResultJson): List<FilmDetails> {
        return from.films?.map {
            FilmDetails(
                title = it.title,
                year = it.year,
                type = it.type,
            )
        } ?: emptyList()
    }
}
