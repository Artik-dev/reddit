package com.artik.domain.mapper

import com.artik.domain.entity.TopChildrenEntity
import com.artik.domain.entity.TopEntity
import com.artik.remote.data.response.TopChildrenResponse
import com.artik.remote.data.response.TopResponse

fun TopResponse.toEntity(): TopEntity {
    return TopEntity(
        children = children?.map { it.data.toEntity() }.orEmpty(),
        after = after.orEmpty(),
        before = before.orEmpty()
    )
}

fun TopChildrenResponse.toEntity(): TopChildrenEntity {
    return TopChildrenEntity(
        authorName = authorName.orEmpty(),
        title = title.orEmpty(),
        created = created ?: 0F,
        thumbnail = thumbnail.orEmpty(),
        largeImage = largeImage.orEmpty()
    )
}