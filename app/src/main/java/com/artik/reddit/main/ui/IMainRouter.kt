package com.artik.reddit.main.ui

import android.graphics.Bitmap

interface IMainRouter {
    fun showLargeImageDialog(url: String, block: (fileName: String, bitmap: Bitmap) -> Unit)
}