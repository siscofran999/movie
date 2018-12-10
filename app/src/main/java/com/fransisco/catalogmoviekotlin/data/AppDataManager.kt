package com.fransisco.catalogmoviekotlin.data

import android.content.Context
import com.fransisco.catalogmoviekotlin.data.model.MovieResponse
import com.fransisco.catalogmoviekotlin.data.network.ApiHelper
import io.reactivex.Single
import javax.inject.Inject

class AppDataManager @Inject constructor(private val context: Context, private val apiHelper: ApiHelper) : DataManager {

    override fun getMovieNowPlayingApiCall(): Single<MovieResponse> = apiHelper.getMovieNowPlayingApiCall()

    override fun getMovieUpcomingApiCall(): Single<MovieResponse>  = apiHelper.getMovieUpcomingApiCall()
}