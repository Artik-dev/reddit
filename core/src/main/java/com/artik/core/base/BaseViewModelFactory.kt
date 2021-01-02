package com.artik.core.base

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

abstract class BaseViewModelFactory<VM : ViewModel> : ViewModelProvider.NewInstanceFactory() {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return createViewModel() as T
    }

    abstract fun createViewModel(): VM
}