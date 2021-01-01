package com.artik.remote.repository

import com.artik.remote.data.response.RedditResponse

interface ITopRepository {
    suspend fun getTopPosts(limit: Int): List<RedditResponse>?
}