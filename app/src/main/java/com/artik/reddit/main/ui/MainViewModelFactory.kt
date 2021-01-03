package com.artik.reddit.main.ui

import android.content.ContentResolver
import com.artik.core.PermissionManager
import com.artik.core.base.BaseViewModelFactory
import com.artik.domain.useCase.top.TopUseCase

class MainViewModelFactory(
    private val topUseCase: TopUseCase,
    private val router: IMainRouter,
    private val permissionManager: PermissionManager,
    private val contentResolver: ContentResolver
) :
    BaseViewModelFactory<MainViewModel>() {
    override fun createViewModel(): MainViewModel {
        return MainViewModel(
            useCase = topUseCase,
            router = router,
            permissionManager = permissionManager,
            contentResolver = contentResolver
        )
    }
}