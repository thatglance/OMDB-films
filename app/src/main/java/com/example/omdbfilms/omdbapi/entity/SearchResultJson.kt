package com.example.omdbfilms.omdbapi.entity

import com.example.omdbfilms.omdbapi.entity.FilmDetailsJson
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty

@JsonIgnoreProperties(ignoreUnknown = true)
data class SearchResultJson @JsonCreator constructor(
    @field:JsonProperty("Search")
    val films: List<FilmDetailsJson>?,
//    @field:JsonProperty("Response")
//    val response: String
)