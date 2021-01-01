package com.artik.core.base

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job

class BaseViewModel : ViewModel() {

    private val ioJob = Job()

    protected val ioScope = CoroutineScope(Dispatchers.IO + ioJob)

    override fun onCleared() {
        ioJob.cancel()
        super.onCleared()
    }
}