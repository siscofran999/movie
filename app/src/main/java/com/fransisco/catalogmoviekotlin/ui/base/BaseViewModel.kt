package com.fransisco.catalogmoviekotlin.ui.base

import android.arch.lifecycle.ViewModel
import android.databinding.ObservableBoolean
import com.fransisco.catalogmoviekotlin.data.DataManager
import com.fransisco.catalogmoviekotlin.utils.SchedulerProvider
import io.reactivex.disposables.CompositeDisposable

abstract class BaseViewModel<N> constructor(var dataManager: DataManager, var schedulerProvider: SchedulerProvider) : ViewModel() {

    var navigator: N? = null
    internal val isLoading = ObservableBoolean(false)

    val compositeDisposable: CompositeDisposable = CompositeDisposable()

    fun setIsLoading(isLoading: Boolean) {
        this.isLoading.set(isLoading)
    }

    override fun onCleared() {
        compositeDisposable.dispose()
        super.onCleared()
    }
}
