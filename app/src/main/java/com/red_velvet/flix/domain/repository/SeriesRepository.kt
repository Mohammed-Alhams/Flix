package com.red_velvet.flix.domain.repository

import com.red_velvet.flix.data.remote.recoures.Pagination
import com.red_velvet.flix.data.remote.recoures.image.ImagesResource
import com.red_velvet.flix.data.remote.recoures.series.SeriesResource
import com.red_velvet.flix.domain.entity.ReviewEntity
import com.red_velvet.flix.domain.entity.TrailerEntity
import com.red_velvet.flix.domain.entity.series.EpisodeEntity
import com.red_velvet.flix.domain.entity.series.SeasonEntity
import com.red_velvet.flix.domain.entity.series.SeriesEntity

interface SeriesRepository {

    suspend fun getPopularSeries(page: Int? = null): List<SeriesEntity>
    suspend fun getTopRatedSeries(page: Int? = null): List<SeriesEntity>
    suspend fun getOnTheAirSeries(page: Int? = null): List<SeriesEntity>
    suspend fun getAiringTodaySeries(page: Int? = null): List<SeriesEntity>
    suspend fun getSeriesRecommendations(seriesId: Int, page: Int?): List<SeriesEntity>
    suspend fun getLatestSeries(): SeriesEntity
    suspend fun getSeriesKeywords(seriesId: Int): List<String>
    suspend fun getSeriesReviews(seriesId: Int, page: Int?): List<ReviewEntity>
    suspend fun rateSeries(seriesId: Int, rate: Float)
    suspend fun getSeasonDetails(seriesId: Int, seasonNumber: Int): SeasonEntity
    suspend fun getSeasonImages(seriesId: Int, seasonNumber: Int): List<String>
    suspend fun getSeriesTrailers(seriesId: Int): List<TrailerEntity>
    suspend fun getEpisodeDetails(seriesId: Int, season: Int, episode: Int): EpisodeEntity
    suspend fun getEpisodeImages(seriesId: Int, season: Int, episode: Int): List<String>
    suspend fun getEpisodeTrailers(seriesId: Int, season: Int, episode: Int): List<TrailerEntity>
    suspend fun rateEpisode(seriesId: Int, season: Int, episode: Int, rate: Float)
    suspend fun getSeriesDetails(seriesId: Int): SeriesResource
    suspend fun getSeriesImages(seriesId: Int): ImagesResource
    suspend fun getSimilarSeries(seriesId: Int, page: Int?): Pagination<SeriesResource>

    suspend fun getLocalPopularSeries(): List<SeriesEntity>
    suspend fun getLocalTopRatedSeries(): List<SeriesEntity>
    suspend fun getLocalOnTheAirSeries(): List<SeriesEntity>
    suspend fun getLocalAiringTodaySeries(): List<SeriesEntity>
    suspend fun cachePopularSeries(series: List<SeriesEntity>)
    suspend fun cacheTopRatedSeries(series: List<SeriesEntity>)
    suspend fun cacheOnTheAirSeries(series: List<SeriesEntity>)
    suspend fun cacheAiringTodaySeries(series: List<SeriesEntity>)
}