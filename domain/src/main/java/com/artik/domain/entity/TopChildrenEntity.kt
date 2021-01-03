package com.artik.domain.entity

data class TopChildrenEntity(
    val authorName: String,
    val commentCount: Int,
    val created: Long,
    val thumbnail: String,
    val largeImage: String
)