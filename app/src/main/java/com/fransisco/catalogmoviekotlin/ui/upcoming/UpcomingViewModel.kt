package com.fransisco.catalogmoviekotlin.ui.upcoming

import android.arch.lifecycle.MutableLiveData
import android.databinding.ObservableArrayList
import android.util.Log
import com.fransisco.catalogmoviekotlin.data.DataManager
import com.fransisco.catalogmoviekotlin.data.model.Movie
import com.fransisco.catalogmoviekotlin.ui.base.BaseViewModel
import com.fransisco.catalogmoviekotlin.utils.SchedulerProvider

class UpcomingViewModel constructor(dataManager: DataManager, schedulerProvider: SchedulerProvider)  : BaseViewModel<UpcomingNavigator>(dataManager = dataManager, schedulerProvider = schedulerProvider) {

    private val upcomingMovieObsArrayList = ObservableArrayList<Movie>()

    private val upcomingMovieLiveData: MutableLiveData<List<Movie>> = MutableLiveData()

    fun fetchUpcoming() {
        compositeDisposable.add(dataManager.getMovieUpcomingApiCall()
                .compose(schedulerProvider.ioToMainSingleScheduler())
                .subscribe({

                    Log.i(UpcomingFragment.TAG, it.results?.size.toString())
                    upcomingMovieLiveData.value = it.results

                }, {

                    Log.e(UpcomingFragment.TAG, it.message)

                }))
    }

    fun getUpcomingMovieListLiveData(): MutableLiveData<List<Movie>> {
        return upcomingMovieLiveData
    }

    fun getUpcomingMovieObsArrayList(): ObservableArrayList<Movie> {
        return upcomingMovieObsArrayList
    }

    fun addUpcomingMovieItemsToList(movies: List<Movie>) {
        upcomingMovieObsArrayList.clear()
        upcomingMovieObsArrayList.addAll(movies)
    }
}