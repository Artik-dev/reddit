package com.artik.domain.useCase.top

import com.artik.domain.entity.TopEntity
import com.artik.domain.mapper.toEntity
import com.artik.remote.repository.ITopRepository

class TopInteractor(private val repository: ITopRepository) : TopUseCase {
    override suspend fun getTopPosts(limit: Int, nextPageKey: String?): TopEntity? {
        return repository.getTopPosts(limit, nextPageKey)?.toEntity()
    }
}