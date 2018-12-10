package com.fransisco.catalogmoviekotlin.ui.trending

import android.arch.lifecycle.ViewModelProvider
import android.support.v7.widget.GridLayoutManager
import com.fransisco.catalogmoviekotlin.ViewModelProviderFactory
import com.fransisco.catalogmoviekotlin.data.DataManager
import com.fransisco.catalogmoviekotlin.utils.SchedulerProvider
import dagger.Module
import dagger.Provides

@Module
class TrendingFragmentModule {

    @Provides
    internal fun provideNowPlayingViewModel(dataManager: DataManager, schedulerProvider: SchedulerProvider)
            : TrendingViewModel = TrendingViewModel(dataManager, schedulerProvider)

    @Provides
    internal fun provideNowPlayingViewModelProviderFactory(viewModel: TrendingViewModel)
            : ViewModelProvider.Factory = ViewModelProviderFactory(viewModel)

    @Provides
    internal fun provideNowPlayingAdapter(dataManager: DataManager, schedulerProvider: SchedulerProvider)
            : TrendingAdapter = TrendingAdapter(ArrayList(), dataManager = dataManager, schedulerProvider = schedulerProvider)

    @Provides
    internal fun provideGridLayoutManager(fragment: TrendingFragment): GridLayoutManager = GridLayoutManager(fragment.activity,2)
}