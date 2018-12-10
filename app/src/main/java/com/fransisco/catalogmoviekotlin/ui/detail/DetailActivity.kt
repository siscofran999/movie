package com.fransisco.catalogmoviekotlin.ui.detail

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.util.Log
import com.android.databinding.library.baseAdapters.BR
import com.fransisco.catalogmoviekotlin.BuildConfig
import com.fransisco.catalogmoviekotlin.R
import com.fransisco.catalogmoviekotlin.data.model.Movie
import com.fransisco.catalogmoviekotlin.databinding.ActivityDetailBinding
import com.fransisco.catalogmoviekotlin.ui.base.BaseActivity
import com.fransisco.iniBolaku.utils.extension.loadImage
import dagger.android.DispatchingAndroidInjector
import kotlinx.android.synthetic.main.activity_detail.*
import javax.inject.Inject

class DetailActivity : BaseActivity<ActivityDetailBinding, DetailViewModel>(), DetailNavigator {

    companion object {
        const val TAG = "DetailActivity"
        const val MOVIE_INTENT = "MOVIE_INTENT"
    }

//    @Inject
//    internal lateinit var fragmentDispatchingAndroidInjector: DispatchingAndroidInjector<Fragment>

    @Inject
    internal lateinit var viewModel: DetailViewModel

    internal lateinit var binding: ActivityDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        getViewDataBinding()?.let { binding = it }
        viewModel.navigator = this

        val movie: Movie = intent.getParcelableExtra(MOVIE_INTENT)

        setData(movie)
        Log.i(TAG, "Movie id : ${movie.id}")
    }

    private fun setData(movie: Movie) {
        movie.posterPath?.let { detail_img.loadImage(BuildConfig.BASE_URL_POSTER_PATH_SMALL + it) }
        movie.title?.let { detail_title.text = movie.title }
        movie.overview?.let { detail_desc.text = movie.overview }
        movie.voteAverage?.let { detail_value.text = movie.voteAverage.toString()+" / 10" }
    }

    override fun getViewModel(): DetailViewModel = viewModel

    override fun getBindingVariable(): Int = BR.viewModel

    override fun getLayoutId(): Int = R.layout.activity_detail

    override fun onFragmentAttached() { }

    override fun onFragmentDetached(tag: String) { }

}
