package com.fransisco.catalogmoviekotlin.ui.nowPlaying

import android.arch.lifecycle.MutableLiveData
import android.databinding.ObservableArrayList
import android.util.Log
import com.fransisco.catalogmoviekotlin.data.DataManager
import com.fransisco.catalogmoviekotlin.data.model.Movie
import com.fransisco.catalogmoviekotlin.ui.base.BaseViewModel
import com.fransisco.catalogmoviekotlin.utils.SchedulerProvider

class NowPlayingViewModel constructor(dataManager: DataManager, schedulerProvider: SchedulerProvider) : BaseViewModel<NowPlayingNavigator>(dataManager = dataManager, schedulerProvider = schedulerProvider) {

    private val nowPlayingMovieObsArrayList = ObservableArrayList<Movie>()

    private val nowPlayingMovieLiveData: MutableLiveData<List<Movie>> = MutableLiveData()

    fun fetchNowPlaying() {
        compositeDisposable.add(dataManager.getMovieNowPlayingApiCall()
                .compose(schedulerProvider.ioToMainSingleScheduler())
                .subscribe({

                    Log.i(NowPlayingFragment.TAG, it.results?.size.toString())
                    nowPlayingMovieLiveData.value = it.results

                }, {

                    Log.e(NowPlayingFragment.TAG, it.message)

                }))
    }

    fun getNowPlayingMovieListLiveData(): MutableLiveData<List<Movie>> {
        return nowPlayingMovieLiveData
    }

    fun getNowPlayingMovieObsArrayList(): ObservableArrayList<Movie> {
        return nowPlayingMovieObsArrayList
    }

    fun addNowPlayingMovieItemsToList(movies: List<Movie>) {
        nowPlayingMovieObsArrayList.clear()
        nowPlayingMovieObsArrayList.addAll(movies)
    }
}