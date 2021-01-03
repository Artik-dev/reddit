package com.artik.remote.api

import com.artik.remote.data.DataWrapper
import com.artik.remote.data.response.TopResponse
import kotlinx.coroutines.Deferred
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface TopApi {
    @GET("top.json")
    fun getTopPostsAsync(
        @Query("limit") limit: Int,
        @Query("after") nextPageKey: String?
    ): Deferred<Response<DataWrapper<TopResponse>>>
}