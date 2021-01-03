package com.artik.reddit.main.adapter

import androidx.recyclerview.widget.DiffUtil
import com.artik.domain.entity.TopChildrenEntity

class TopPostDiffUtilCallback : DiffUtil.ItemCallback<TopChildrenEntity>() {
    override fun areItemsTheSame(oldItem: TopChildrenEntity, newItem: TopChildrenEntity): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(
        oldItem: TopChildrenEntity,
        newItem: TopChildrenEntity
    ): Boolean {
        return oldItem.authorName == newItem.authorName &&
                oldItem.commentCount == newItem.commentCount &&
                oldItem.created == newItem.created &&
                oldItem.thumbnail == newItem.thumbnail &&
                oldItem.largeImage == newItem.largeImage
    }
}