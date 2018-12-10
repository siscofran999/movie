package com.fransisco.catalogmoviekotlin.ui.topRated

import android.arch.lifecycle.ViewModelProvider
import android.support.v7.widget.GridLayoutManager
import com.fransisco.catalogmoviekotlin.ViewModelProviderFactory
import com.fransisco.catalogmoviekotlin.data.DataManager
import com.fransisco.catalogmoviekotlin.utils.SchedulerProvider
import dagger.Module
import dagger.Provides

@Module
class TopRatedFragmentModule {

    @Provides
    internal fun provideUpcomingViewModel(dataManager: DataManager, schedulerProvider: SchedulerProvider)
            : TopRatedViewModel = TopRatedViewModel(dataManager, schedulerProvider)

    @Provides
    internal fun provideUpcomingViewModelProviderFactory(viewModel: TopRatedViewModel)
            : ViewModelProvider.Factory = ViewModelProviderFactory(viewModel)

    @Provides
    internal fun provideUpcomingAdapter(dataManager: DataManager, schedulerProvider: SchedulerProvider)
            : TopRatedAdapter = TopRatedAdapter(ArrayList(), dataManager = dataManager, schedulerProvider = schedulerProvider)

    @Provides
    internal fun provideGridLayoutManager(fragment: TopRatedFragment): GridLayoutManager = GridLayoutManager(fragment.activity, 2)
}