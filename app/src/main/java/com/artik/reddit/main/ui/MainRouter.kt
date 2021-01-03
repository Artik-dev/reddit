package com.artik.reddit.main.ui

import android.graphics.Bitmap
import android.view.LayoutInflater
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.content.res.AppCompatResources
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
        block: (bitmap: Bitmap) -> Unit
    ) {
        activity?.let {
            LayoutInflater.from(it).inflate(R.layout.dialog_large_image, null, false).let {

                val dialog = AlertDialog.Builder(activity!!)
                    .setView(it)
                    .create()
                it.apply {

                    Glide.with(this).load(url)
                        .placeholder(
                            AppCompatResources.getDrawable(
                                activity!!,
                                R.drawable.ic_placeholder
                            )
                        )
                        .into(imageView)

                    btnClose.setOnClickListener {
                        dialog.dismiss()
                    }

                    btnSave.setOnClickListener {

                        imageView.drawable.toBitmap()
                            .let {
                                block.invoke(it)
                                dialog.dismiss()
                            }
                    }
                }
                dialog.show()
            }
        }
    }

    override fun showToast(message: String) {
        activity?.let {
            Toast.makeText(it, message, Toast.LENGTH_SHORT).show()
        }
    }

    override fun showToast(message: Int) {
        activity?.let {
            Toast.makeText(it, it.resources.getString(message), Toast.LENGTH_SHORT).show()
        }
    }
}