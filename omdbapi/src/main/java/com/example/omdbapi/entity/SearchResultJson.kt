package com.example.omdbapi.entity

import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty

@JsonIgnoreProperties(ignoreUnknown = true)
data class SearchResultJson @JsonCreator constructor(
    @field:JsonProperty("Search")
    val search: List<FilmDetailsJson>?,
    @field:JsonProperty("Response")
    val response: String
)