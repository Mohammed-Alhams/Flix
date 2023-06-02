package com.red_velvet.flix.domain.usecase

import com.red_velvet.flix.data.repository.MovieRepository
import com.red_velvet.flix.domain.mapper.movie.toModel
import com.red_velvet.flix.domain.model.movie.Movie
import javax.inject.Inject

class DiscoverMoviesUsecase @Inject constructor(
    private val movieRepository: MovieRepository
) {
    suspend operator fun invoke(
        includeAdult: Boolean = false,
        includeVideo: Boolean,
        language: String? = null,
        page: Int = 1,
        primaryReleaseYear: Int? = null,
        primaryReleaseDateGte: String? = null,
        primaryReleaseDateLte: String? = null,
        region: String? = null,
        releaseDateGte: String? = null,
        releaseDateLte: String? = null,
        sortBy: String,
        voteAverageGte: Double? = null,
        voteAverageLte: Double? = null,
        voteCountGte: Int? = null,
        voteCountLte: Int? = null,
        watchRegion: String? = null,
        withCast: String? = null,
        withCrew: String? = null,
        withGenres: String? = null,
        withKeywords: String? = null,
        withOriginCountry: String? = null,
        withOriginalLanguage: String? = null,
        withPeople: String? = null,
        withReleaseType: Int? = null,
        withRuntimeGte: Int? = null,
        withRuntimeLte: Int? = null,
        withWatchMonetizationTypes: String? = null,
        withWatchProviders: String? = null,
        withoutGenres: String? = null,
        withoutKeywords: String? = null,
        withoutWatchProviders: String? = null,
        withoutCompanies: String? = null,
        year: Int? = null
    ): List<Movie> {
        return movieRepository.discoverMovies(
            includeAdult,
            includeVideo,
            language,
            page,
            primaryReleaseYear,
            primaryReleaseDateGte,
            primaryReleaseDateLte,
            region,
            releaseDateGte,
            releaseDateLte,
            sortBy,
            voteAverageGte,
            voteAverageLte,
            voteCountGte,
            voteCountLte,
            watchRegion,
            withCast,
            withCrew,
            withGenres,
            withKeywords,
            withOriginCountry,
            withOriginalLanguage,
            withPeople,
            withReleaseType,
            withRuntimeGte,
            withRuntimeLte,
            withWatchMonetizationTypes,
            withWatchProviders,
            withoutGenres,
            withoutKeywords,
            withoutWatchProviders,
            withoutCompanies,
            year
        ).toModel()
    }
}