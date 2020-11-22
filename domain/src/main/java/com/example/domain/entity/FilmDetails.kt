package com.example.domain.entity

data class FilmDetails(
    val imdbID: String,
    val title: String,
    val year: String,
    val type: String,
    val genre: String?,
    val plot: String?
)
