package com.artik.domain.useCase.top

import com.artik.domain.entity.TopEntity
import com.artik.domain.mapper.toEntity
import com.artik.remote.repository.ITopRepository

class TopInteractor(private val repository: ITopRepository) : TopUseCase {
    override suspend fun getTopPosts(limit: Int): List<TopEntity>?{
        return repository.getTopPosts(limit)?.map { it.toEntity() }
    }
}