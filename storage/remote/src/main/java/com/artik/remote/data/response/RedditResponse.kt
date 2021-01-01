package com.artik.remote.data.response

import com.artik.remote.data.DataWrapper

data class RedditResponse(
    val children: List<DataWrapper<RedditChildrenResponse>>?,
    val after: String?,
    val before: String?
)