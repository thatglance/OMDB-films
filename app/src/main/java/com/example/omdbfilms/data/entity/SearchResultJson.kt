package com.example.omdbfilms.data.entity

import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty

@JsonIgnoreProperties(ignoreUnknown = true)
data class SearchResultJson @JsonCreator constructor(
    @field:JsonProperty("Search")
    val films: List<FilmDetailsJson>?
)
