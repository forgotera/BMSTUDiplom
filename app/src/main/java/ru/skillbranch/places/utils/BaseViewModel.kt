package ru.skillbranch.places.utils

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.*
import timber.log.Timber


open class BaseViewModel: ViewModel() {

    private val viewModelJob = SupervisorJob()

    protected val uiScope = CoroutineScope(Dispatchers.Main + viewModelJob)
    protected val handler = CoroutineExceptionHandler { _, exception ->
        handleException(exception)
        Timber.e(exception)
    }

    open fun handleException(throwable: Throwable) {}

    /**
     * Cancel all coroutines when the ViewModel is cleared
     */
    override fun onCleared() {
        super.onCleared()
        uiScope.coroutineContext.cancelChildren()
    }
}