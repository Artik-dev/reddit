package com.artik.remote.repository

import com.artik.remote.api.TopApi
import com.artik.remote.data.response.TopResponse
import java.lang.Exception

class TopRepository(private val api: TopApi) : ITopRepository {
    override suspend fun getTopPosts(limit: Int, nextPageKey: String?): TopResponse? {
        return try {
            api.getTopPostsAsync(limit, nextPageKey).await().let {
                if (it.isSuccessful) {
                    return it.body()?.data
                } else null
            }
        } catch (e: Exception) {
            null
        }

    }
}