package com.red_velvet.flix.domain.usecase.home.movies

import com.red_velvet.flix.domain.entity.movie.MovieEntity
import com.red_velvet.flix.domain.repository.MovieRepository
import com.red_velvet.flix.domain.usecase.FormatMediaDateAndCountryCodeUsecase
import com.red_velvet.flix.domain.usecase.cachingTimeStamps.ShouldCacheApiResponseUseCase
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject


class GetTopRatedMoviesUseCase @Inject constructor(
    private val movieRepository: MovieRepository,
    private val shouldCacheApiResponseUseCase: ShouldCacheApiResponseUseCase,
    private val formatMediaDateAndCountryCodeUsecase: FormatMediaDateAndCountryCodeUsecase,
) {

    suspend operator fun invoke(): Flow<List<MovieEntity>> {
        if (shouldCacheApiResponseUseCase("top_rated_movies")) {
            refreshLocalTopRatedMovies()
        }
        return movieRepository.getLocalTopRatedMovies()
    }

    private suspend fun getTopRatedMovies(): List<MovieEntity> {
        return movieRepository.getTopRatedMovies().map {
            it.copy(
                formattedDate = formatMediaDateAndCountryCodeUsecase(
                    it.releaseDate, it.originalLanguage
                ),
            )
        }
    }

    private suspend fun refreshLocalTopRatedMovies() {
        val topRatedMovies = getTopRatedMovies()
        if (topRatedMovies.isNotEmpty()) {

            movieRepository.cacheTopRatedMovies(topRatedMovies)
        }
    }

}
