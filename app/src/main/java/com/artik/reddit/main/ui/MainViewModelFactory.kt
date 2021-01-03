package com.artik.reddit.main.ui

import com.artik.core.base.BaseViewModelFactory
import com.artik.domain.useCase.top.TopUseCase

class MainViewModelFactory(private val topUseCase: TopUseCase,
private val router: IMainRouter) :
    BaseViewModelFactory<MainViewModel>() {
    override fun createViewModel(): MainViewModel {
        return MainViewModel(useCase = topUseCase, router = router)
    }
}