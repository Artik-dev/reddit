package com.artik.reddit.main.ui

import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import com.artik.core.base.BaseViewModel
import com.artik.domain.useCase.top.TopUseCase
import com.artik.reddit.main.dataSource.MainDataSource
import java.util.concurrent.Executors

class MainViewModel(
    private val useCase: TopUseCase
) : BaseViewModel() {

    private val factory = MainDataSource.Factory(
        useCase,
        ioScope
    )

    private val pagedListConfig = PagedList.Config.Builder()
        .setEnablePlaceholders(false)
        .setPageSize(MainDataSource.PAGE_SIZE)
        .build()

    val mainRecyclerDataSource = LivePagedListBuilder(
        factory,
        pagedListConfig
    ).setFetchExecutor(Executors.newSingleThreadExecutor()).build()
}