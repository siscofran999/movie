package com.fransisco.catalogmoviekotlin.data.network

import android.content.Context
import com.fransisco.catalogmoviekotlin.data.model.MovieResponse
import com.fransisco.catalogmoviekotlin.utils.ApiEndPoint
import com.rx2androidnetworking.Rx2AndroidNetworking
import io.reactivex.Single
import javax.inject.Inject

class AppApiHelper @Inject constructor(context: Context) : ApiHelper {

    override fun getMovieSearchApiCall(query: String?): Single<MovieResponse> =
            Rx2AndroidNetworking.get(ApiEndPoint.END_POINT_MOVIE_API)
                    .addQueryParameter("api_key", ApiEndPoint.API_KEY)
                    .addQueryParameter("language", "en-US")
                    .addQueryParameter("query", query)
                    .build()
                    .getObjectSingle(MovieResponse::class.java)

    override fun getMovieNowPlayingApiCall(): Single<MovieResponse> =
            Rx2AndroidNetworking.get(ApiEndPoint.END_POINT_MOVIE_Trending_API)
                    .addQueryParameter("api_key", ApiEndPoint.API_KEY)
                    .addQueryParameter("language", "en-US")
                    .build()
                    .getObjectSingle(MovieResponse::class.java)

    override fun getMovieUpcomingApiCall(): Single<MovieResponse> =
            Rx2AndroidNetworking.get(ApiEndPoint.END_POINT_MOVIE_TopRated_API)
                    .addQueryParameter("api_key", ApiEndPoint.API_KEY)
                    .addQueryParameter("language", "en-US")
                    .build()
                    .getObjectSingle(MovieResponse::class.java)
}