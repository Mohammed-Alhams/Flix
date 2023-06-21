package com.red_velvet.flix.domain.entity.movie


data class MovieEntity(
    val id: Int,
    val title: String,
    val imageUrl: String,
    val popularity: Double,
    val releaseDate: String,
    val voteAverage: Double,
    val originalLanguage: String,
    val formattedDate: String,
    )