package com.red_velvet.flix.domain.usecase

import com.red_velvet.flix.domain.model.series.TVShow
import com.red_velvet.flix.domain.repository.TVShowsRepository
import javax.inject.Inject

class GetOnTheAirTvShowUsecase @Inject constructor(private val tvShowsRepository: TVShowsRepository) {
    suspend operator fun invoke(): List<TVShow> {
        return tvShowsRepository.getOnTheAirTvShow()
    }
}