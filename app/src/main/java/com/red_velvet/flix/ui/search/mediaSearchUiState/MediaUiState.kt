package com.red_velvet.flix.ui.search.mediaSearchUiState

import com.red_velvet.flix.BuildConfig
import com.red_velvet.flix.domain.model.movie.Movie

data class MediaUiState(
    val mediaID: Int,
    val mediaName: String,
    val mediaImage: String,
    val mediaPopularity: Double,
    val mediaReleaseDate: String,
    val mediaVoteAverage: Double,
)
internal fun Movie.toUiState(): MediaUiState {
    return MediaUiState(
        mediaID = id,
        mediaName = title,
        mediaImage = BuildConfig.IMAGE_BASE_PATH,
        mediaPopularity = popularity,
        mediaReleaseDate = releaseDate,
        mediaVoteAverage = voteAverage
    )

}