package com.artik.reddit.main.holder

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.artik.domain.entity.TopChildrenEntity
import com.artik.reddit.R
import com.artik.reddit.databinding.ItemPostBinding
import com.artik.reddit.main.adapter.ImageClickHandler

class MainViewHolder(
    private val binding: ItemPostBinding
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(data: TopChildrenEntity, clickHandler: ImageClickHandler) {
        binding.data = data
        binding.clickHandler = clickHandler
    }

    companion object {
        fun create(parent: ViewGroup): MainViewHolder {
            val binding: ItemPostBinding = DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                R.layout.item_post,
                parent,
                false
            )

            return MainViewHolder(binding)
        }
    }
}