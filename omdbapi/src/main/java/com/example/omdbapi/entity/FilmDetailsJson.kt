package com.example.omdbapi.entity

import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty

@JsonIgnoreProperties(ignoreUnknown = true)
data class FilmDetailsJson @JsonCreator constructor(
    @field:JsonProperty("imdbID")
    val imdbID: String,
    @field:JsonProperty("Title")
    val title: String,
    @field:JsonProperty("Year")
    val year: String,
    @field:JsonProperty("Type")
    val type: String,
    @field:JsonProperty("Genre")
    val genre: String?,
    @field:JsonProperty("Plot")
    val plot: String?,
    @field:JsonProperty("Response")
    val isSuccessful: String?
)
