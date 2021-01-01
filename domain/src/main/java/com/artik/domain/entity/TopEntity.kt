package com.artik.domain.entity

import com.artik.remote.data.DataWrapper

data class TopEntity(
    val children: List<TopChildrenEntity>,
    val after: String,
    val before: String
)