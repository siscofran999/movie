package com.fransisco.catalogmoviekotlin.data.network

import com.fransisco.catalogmoviekotlin.data.model.MovieResponse
import io.reactivex.Single

interface ApiHelper {

    fun getMovieNowPlayingApiCall(): Single<MovieResponse>

    fun getMovieUpcomingApiCall(): Single<MovieResponse>
}