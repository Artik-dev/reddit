package com.artik.core.ba

import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.artik.core.Constants
import java.util.*

object TextAdapter {
    @BindingAdapter(
        "app:created"
    )
    @JvmStatic
    fun setCreatedTime(
        view: TextView,
        created: Float
    ) {
        (Date().time - created).let {
            Constants.SIMPLE_DATA_FORMAT_HH_MM_SS.format(it).let {
                view.text = it
            }
        }
    }
}