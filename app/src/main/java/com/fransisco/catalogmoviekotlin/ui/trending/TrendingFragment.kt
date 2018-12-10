package com.fransisco.catalogmoviekotlin.ui.trending


import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import android.content.Intent
import android.os.Bundle
import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.LinearLayoutManager
import android.util.TypedValue
import android.view.View
import com.fransisco.catalogmoviekotlin.BR

import com.fransisco.catalogmoviekotlin.R
import com.fransisco.catalogmoviekotlin.databinding.FragmentTrendingBinding
import com.fransisco.catalogmoviekotlin.ui.base.BaseFragment
import com.fransisco.catalogmoviekotlin.ui.custom.GridSpacingItemDecoration
import com.fransisco.catalogmoviekotlin.ui.detail.DetailActivity
import kotlinx.android.synthetic.main.fragment_trending.*
import javax.inject.Inject

class TrendingFragment : BaseFragment<FragmentTrendingBinding, TrendingViewModel>(), TrendingNavigator {

    companion object {
        var TAG = "TrendingFragment"

        fun newInstance(): TrendingFragment = TrendingFragment()
    }

    internal lateinit var binding: FragmentTrendingBinding

    private lateinit var viewModel: TrendingViewModel

    @Inject
    internal lateinit var mLayoutManager: GridLayoutManager

    @Inject
    internal lateinit var adapter: TrendingAdapter

    @Inject
    internal lateinit var viewModelFactory: ViewModelProvider.Factory

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        getViewDataBinding().let { binding = it }
        viewModel.navigator = this

        adapter.setOnItemCLickListener {
            val intent = Intent(activity?.applicationContext, DetailActivity::class.java)
            intent.putExtra(DetailActivity.MOVIE_INTENT, it)
            startActivity(intent)
        }

        viewModel.fetchNowPlaying()

        setupRecyclerview()
        subscribeToLiveData()
    }

    private fun setupRecyclerview() {
        mLayoutManager.orientation = LinearLayoutManager.VERTICAL
        nowPlayingRecyclerView.layoutManager = mLayoutManager
        nowPlayingRecyclerView.itemAnimator = DefaultItemAnimator()
        nowPlayingRecyclerView.addItemDecoration(GridSpacingItemDecoration(2,dpToPx(10),true))
        nowPlayingRecyclerView.adapter = adapter
    }

    private fun subscribeToLiveData() {
        viewModel.getNowPlayingMovieListLiveData().observe(this, Observer {
            it?.let { viewModel.addNowPlayingMovieItemsToList(it) }
        })
    }

    override fun getViewModel(): TrendingViewModel {
        viewModel = ViewModelProviders.of(this, viewModelFactory).get(TrendingViewModel::class.java)
        return viewModel
    }

    override fun getBindingVariable(): Int = BR.viewModel

    override fun getLayoutId(): Int = R.layout.fragment_trending

    private fun dpToPx(dp: Int): Int {
        val r = resources
        return Math.round(TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp.toFloat(), r.displayMetrics))
    }
}
