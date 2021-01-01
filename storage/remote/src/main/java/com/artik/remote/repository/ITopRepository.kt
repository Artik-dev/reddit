package com.artik.remote.repository

import com.artik.remote.data.response.TopResponse

interface ITopRepository {
    suspend fun getTopPosts(limit: Int): List<TopResponse>?
}