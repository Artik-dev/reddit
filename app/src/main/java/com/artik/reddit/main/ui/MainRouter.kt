package com.artik.reddit.main.ui

import android.graphics.Bitmap
import android.view.LayoutInflater
import androidx.appcompat.app.AlertDialog
import androidx.core.graphics.drawable.toBitmap
import com.artik.reddit.R
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.dialog_large_image.view.*

class MainRouter : IMainRouter {
    var activity: MainActivity? = null

    fun attachActivity(a: MainActivity) {
        activity = a
    }

    fun detachActivity() {
        activity = null
    }

    override fun showLargeImageDialog(
        url: String,
        block: (fileName: String, bitmap: Bitmap) -> Unit
    ) {
        activity?.let {
            LayoutInflater.from(it).inflate(R.layout.dialog_large_image, null, false).let {

                val dialog = AlertDialog.Builder(activity!!)
                    .setView(it)
                    .create()
                it.apply {

                    Glide.with(this).load(url)
                        .placeholder(activity!!.resources.getDrawable(R.drawable.ic_placeholder))
                        .into(imageView)

                    btnClose.setOnClickListener {
                        dialog.dismiss()
                    }

                    btnSave.setOnClickListener {
                        imageView.drawable.toBitmap().let {
                            block.invoke("${System.currentTimeMillis()}", it)
                            dialog.dismiss()
                        }
                    }
                }
                dialog.show()
            }
        }
    }
}