package com.example.omdbfilms.data.entity

import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty

@JsonIgnoreProperties(ignoreUnknown = true)
data class FilmDetailsJson @JsonCreator constructor(
    @field:JsonProperty("Title")
    val title: String,
    @field:JsonProperty("Year")
    val year: String,
    @field:JsonProperty("Type")
    val type: String,
)
