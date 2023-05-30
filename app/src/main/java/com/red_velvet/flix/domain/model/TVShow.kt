package com.red_velvet.flix.domain.model


data class TVShow(
    val id: Int,
    val name: String,
    val imageUrl: String,
    val firstAirDate: String,
    val popularity: Double,
    val voteAverage: Double,
)