package com.artik.remote.data.response

import com.google.gson.annotations.SerializedName

data class TopChildrenResponse(
    @SerializedName("author")
    val authorName: String?,
    val title:String?,
    val created:Float?,
    val thumbnail:String?,
    @SerializedName("url")
    val largeImage:String?
)