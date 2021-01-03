package com.artik.reddit.main.ui

import android.graphics.Bitmap

interface IMainRouter {

    fun showLargeImageDialog(url: String, block: (bitmap: Bitmap) -> Unit)

    fun showToast(message: String)
    fun showToast(message: Int)
}