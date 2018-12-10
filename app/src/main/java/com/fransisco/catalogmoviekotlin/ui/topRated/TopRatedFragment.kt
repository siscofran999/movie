package com.fransisco.catalogmoviekotlin.ui.topRated

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
import com.fransisco.catalogmoviekotlin.data.model.Movie
import com.fransisco.catalogmoviekotlin.databinding.FragmentTopRatedBinding
import com.fransisco.catalogmoviekotlin.ui.base.BaseFragment
import com.fransisco.catalogmoviekotlin.ui.custom.GridSpacingItemDecoration
import com.fransisco.catalogmoviekotlin.ui.detail.DetailActivity
import kotlinx.android.synthetic.main.fragment_top_rated.*
import javax.inject.Inject

class TopRatedFragment : BaseFragment<FragmentTopRatedBinding, TopRatedViewModel>(), TopRatedNavigator {

//    override fun gotoDetailActivity() {
//        startActivity(Intent(activity?.applicationContext, DetailActivity::class.java))
//    }

    companion object {
        var TAG = "TopRatedFragment"

        fun newInstance(): TopRatedFragment = TopRatedFragment()
    }

    internal lateinit var binding: FragmentTopRatedBinding

    private lateinit var viewModel: TopRatedViewModel

    @Inject
    internal lateinit var layoutManager: GridLayoutManager

    @Inject
    internal lateinit var adapter: TopRatedAdapter

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



        viewModel.fetchUpcoming()

        setupRecyclerview()
        subscribeToLiveData()
    }

    private fun setupRecyclerview() {
        layoutManager.orientation = LinearLayoutManager.VERTICAL
        upcomingRecyclerView.layoutManager = layoutManager
        upcomingRecyclerView.addItemDecoration(GridSpacingItemDecoration(2,dpToPx(10),true))
        upcomingRecyclerView.itemAnimator = DefaultItemAnimator()
        upcomingRecyclerView.adapter = adapter
    }

    private fun subscribeToLiveData() {
        viewModel.getUpcomingMovieListLiveData().observe(this, Observer {
            it?.let { viewModel.addUpcomingMovieItemsToList(it) }
        })
    }

    override fun getViewModel(): TopRatedViewModel {
        viewModel = ViewModelProviders.of(this, viewModelFactory).get(TopRatedViewModel::class.java)
        return viewModel
    }

    override fun getBindingVariable(): Int = BR.viewModel

    override fun getLayoutId(): Int = R.layout.fragment_top_rated

    private fun dpToPx(dp: Int): Int {
        val r = resources
        return Math.round(TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp.toFloat(), r.displayMetrics))
    }
}
