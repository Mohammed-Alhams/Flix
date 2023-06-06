package com.red_velvet.flix.domain.usecase

import com.red_velvet.flix.domain.model.movie.Movie
import com.red_velvet.flix.domain.repository.MovieRepository
import javax.inject.Inject

class SearchUsecase @Inject constructor(
    private val movieRepository: MovieRepository
) {
    suspend operator fun invoke(
        query: String,
        includeAdult: Boolean = false,
        language: String? = null,
        page: Int? = null
    ): List<Movie> {
        return movieRepository.search(query, includeAdult, language, page)
    }
}