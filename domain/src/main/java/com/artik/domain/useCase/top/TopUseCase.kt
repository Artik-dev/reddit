package com.artik.domain.useCase.top

import com.artik.domain.entity.TopEntity

interface TopUseCase {
    suspend fun getTopPosts(limit: Int, nextPageKey: String?): TopEntity?
}