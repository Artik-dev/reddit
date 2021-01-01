package com.artik.remote.data.response

import com.artik.remote.data.DataWrapper

data class TopResponse(
    val children: List<DataWrapper<TopChildrenResponse>>?,
    val after: String?,
    val before: String?
)