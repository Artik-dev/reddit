package com.artik.domain.entity

data class TopEntity(
    val children: List<TopChildrenEntity>,
    val after: String,
    val before: String
)