package com.red_velvet.flix.domain.repository


import com.red_velvet.flix.domain.entity.ReviewEntity
import com.red_velvet.flix.domain.entity.TrailerEntity
import com.red_velvet.flix.domain.entity.movie.MovieEntity


interface MovieRepository {

    suspend fun getPopularMovies(page: Int? = null): List<MovieEntity>

    suspend fun getUpcomingMovies(page: Int? = null): List<MovieEntity>

    suspend fun getNowPlayingMovies(page: Int? = null): List<MovieEntity>

    suspend fun getTopRatedMovies(page: Int? = null): List<MovieEntity>

    suspend fun getMovieDetails(movieId: Int): MovieEntity

    suspend fun getMovieKeywords(movieId: Int): List<String>

    suspend fun getSimilarMovies(movieId: Int, page: Int? = null): List<MovieEntity>

    suspend fun getMovieTrailers(movieId: Int): List<TrailerEntity>

    suspend fun getLatestMovie(): MovieEntity

    suspend fun getMovieRecommendations(movieId: Int, page: Int? = null): List<MovieEntity>

    suspend fun rateMovie(movieId: Int, rate: Float)

    suspend fun deleteMovieRating(movieId: Int)

    suspend fun getMovieReviews(movieId: Int, page: Int? = null): List<ReviewEntity>

    suspend fun getMoviesWatchlist(page: Int? = null): List<MovieEntity>

    suspend fun getFavoriteMovies(page: Int? = null): List<MovieEntity>

    suspend fun search(query: String, page: Int? = null): List<MovieEntity>

    suspend fun searchMovies(
        query: String,
        includeAdult: Boolean = false,
        language: String? = null,
        primaryReleaseYear: Int? = null,
        page: Int? = null,
        region: String? = null,
        year: Int? = null
    ): List<MovieEntity>


    suspend fun searchPeople(
        query: String,
        includeAdult: Boolean = false,
        language: String? = null,
        page: Int? = null,
    ): List<PersonEntity>


    suspend fun searchTvShows(
        query: String,
        firstAirDateYear: Int? = null,
        includeAdult: Boolean = false,
        language: String? = null,
        page: Int? = null,
        year: Int? = null
    ): List<SeriesEntity>

    suspend fun getMoviesByKeyword(
        keywordId: Int,
        includeAdult: Boolean = false,
        language: String? = null,
        page: Int? = null,
        region: String? = null
    ): List<MovieEntity>
    suspend fun searchMovies(query: String, page: Int?): List<MovieEntity>

    suspend fun getMoviesByKeyword(keywordId: Int, page: Int? = null): List<MovieEntity>

    suspend fun discoverMovies(
        page: Int?,
        sortBy: String?,
        rate: Float?,
        year: Int?
    ): List<MovieEntity>


    suspend fun getLocalPopularMovies(): List<MovieEntity>

    suspend fun getLocalUpcomingMovies(): List<MovieEntity>

    suspend fun getLocalNowPlayingMovies(): List<MovieEntity>

    suspend fun getLocalTopRatedMovies(): List<MovieEntity>

    suspend fun cachePopularMovies(movies: List<MovieEntity>)

    suspend fun cacheUpcomingMovies(movies: List<MovieEntity>)

    suspend fun cacheNowPlayingMovies(movies: List<MovieEntity>)

    suspend fun cacheTopRatedMovies(movies: List<MovieEntity>)
}