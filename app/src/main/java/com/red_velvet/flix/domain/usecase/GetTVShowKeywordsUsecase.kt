package com.red_velvet.flix.domain.usecase

import com.red_velvet.flix.data.repository.TVShowsRepository
import com.red_velvet.flix.domain.mapper.toModel
import com.red_velvet.flix.domain.model.Keyword
import javax.inject.Inject

class GetTVShowKeywordsUsecase @Inject constructor(private val tvShowsRepository: TVShowsRepository) {
    suspend operator fun invoke(seriesId: Int): List<String> {
        return tvShowsRepository.getTVShowKeywords(seriesId).toModel()
    }
}