package com.red_velvet.flix.domain.usecase.home.movies

import android.util.Log
import com.red_velvet.flix.domain.entity.movie.MovieEntity
import com.red_velvet.flix.domain.repository.MovieRepository
import com.red_velvet.flix.domain.usecase.FormatMediaDateAndCountryCodeUsecase
import com.red_velvet.flix.domain.usecase.cachingTimeStamps.ShouldCacheApiResponseUseCase
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject


class GetNowPlayingMoviesUseCase @Inject constructor(
    private val movieRepository: MovieRepository,
    private val shouldCacheApiResponseUseCase: ShouldCacheApiResponseUseCase,
    private val formatMediaDateAndCountryCodeUsecase: FormatMediaDateAndCountryCodeUsecase,
) {

    suspend operator fun invoke(): Flow<List<MovieEntity>> {
        if (shouldCacheApiResponseUseCase("now_playing_movies")) {
            refreshLocalNowPlayingMovies()
        }
        return movieRepository.getLocalNowPlayingMovies()
    }

    private suspend fun getNowPlayingMovies(): List<MovieEntity> {
        return movieRepository.getNowPlayingMovies().map {
            it.copy(
                formattedDate = formatMediaDateAndCountryCodeUsecase(
                    it.releaseDate, it.originalLanguage
                ),
            )
        }
    }

    private suspend fun refreshLocalNowPlayingMovies() {
        val nowPlayingMovies = getNowPlayingMovies()
        if (nowPlayingMovies.isNotEmpty()) {
            movieRepository.cacheNowPlayingMovies(nowPlayingMovies)
        }
    }


}