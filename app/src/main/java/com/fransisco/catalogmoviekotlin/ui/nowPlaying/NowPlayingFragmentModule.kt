package com.fransisco.catalogmoviekotlin.ui.nowPlaying

import android.arch.lifecycle.ViewModelProvider
import android.support.v7.widget.LinearLayoutManager
import com.fransisco.catalogmoviekotlin.ViewModelProviderFactory
import com.fransisco.catalogmoviekotlin.data.DataManager
import com.fransisco.catalogmoviekotlin.utils.SchedulerProvider
import dagger.Module
import dagger.Provides

@Module
class NowPlayingFragmentModule {

    @Provides
    internal fun provideNowPlayingViewModel(dataManager: DataManager, schedulerProvider: SchedulerProvider)
            : NowPlayingViewModel = NowPlayingViewModel(dataManager, schedulerProvider)

    @Provides
    internal fun provideNowPlayingViewModelProviderFactory(viewModel: NowPlayingViewModel)
            : ViewModelProvider.Factory = ViewModelProviderFactory(viewModel)

    @Provides
    internal fun provideNowPlayingAdapter(dataManager: DataManager, schedulerProvider: SchedulerProvider)
            : NowPlayingAdapter = NowPlayingAdapter(ArrayList(), dataManager = dataManager, schedulerProvider = schedulerProvider)

    @Provides
    internal fun provideLinearLayoutManager(fragment: NowPlayingFragment): LinearLayoutManager = LinearLayoutManager(fragment.activity)
}