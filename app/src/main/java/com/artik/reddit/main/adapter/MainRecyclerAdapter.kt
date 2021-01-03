package com.artik.reddit.main.adapter

import android.view.ViewGroup
import androidx.paging.PagedListAdapter
import com.artik.domain.entity.TopChildrenEntity
import com.artik.reddit.main.holder.MainViewHolder

class MainRecyclerAdapter(private val clickHandler: ImageClickHandler) :
    PagedListAdapter<TopChildrenEntity, MainViewHolder>(TopPostDiffUtilCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        return MainViewHolder.create(parent)
    }

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        getItem(position)?.let {
            holder.bind(it, clickHandler)
        }
    }
}