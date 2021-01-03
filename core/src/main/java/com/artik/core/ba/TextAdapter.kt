package com.artik.core.ba

import android.annotation.SuppressLint
import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.artik.core.Constants
import java.text.SimpleDateFormat
import java.util.*


object TextAdapter {
    @SuppressLint("SetTextI18n")
    @BindingAdapter(
        value = [
            "app:created",
            "app:suffix"
        ],
        requireAll = false
    )
    @JvmStatic
    fun setCreatedTime(
        view: TextView,
        created: Long,
        suffix: String
    ) {

        (((System.currentTimeMillis()/1000 - created)/60)/60).let {
            view.text = "$it $suffix"
        }
    }
}