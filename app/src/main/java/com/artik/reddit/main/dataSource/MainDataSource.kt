package com.artik.reddit.main.dataSource

import androidx.paging.DataSource
import androidx.paging.PageKeyedDataSource
import com.artik.domain.entity.TopChildrenEntity
import com.artik.domain.entity.TopEntity
import com.artik.domain.useCase.top.TopUseCase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

class MainDataSource(
    private val useCase: TopUseCase,
    private val scope: CoroutineScope
) : PageKeyedDataSource<String, TopChildrenEntity>() {

    override fun loadInitial(
        params: LoadInitialParams<String>,
        callback: LoadInitialCallback<String, TopChildrenEntity>
    ) {
        scope.launch {
            useCase.getTopPosts(PAGE_SIZE)?.let {
                it.firstOrNull()?.let {
                    callback.onResult(it.children, null, it.after)
                }
            }
        }
    }

    override fun loadBefore(
        params: LoadParams<String>,
        callback: LoadCallback<String, TopChildrenEntity>
    ) {
    }

    override fun loadAfter(
        params: LoadParams<String>,
        callback: LoadCallback<String, TopChildrenEntity>
    ) {
        scope.launch {
            useCase.getTopPosts(PAGE_SIZE)?.let {
                it.firstOrNull()?.let {
                    callback.onResult(it.children, it.after)
                }
            }
        }
    }

    class Factory(
        private val useCase: TopUseCase,
        private val scope: CoroutineScope
    ) : DataSource.Factory<String, TopChildrenEntity>() {
        override fun create(): DataSource<String, TopChildrenEntity> {
            return MainDataSource(useCase, scope)
        }
    }

    companion object {
        const val PAGE_SIZE = 25
    }
}