package com.fransisco.catalogmoviekotlin.ui.upcoming

import android.arch.lifecycle.ViewModelProvider
import android.support.v7.widget.GridLayoutManager
import com.fransisco.catalogmoviekotlin.ViewModelProviderFactory
import com.fransisco.catalogmoviekotlin.data.DataManager
import com.fransisco.catalogmoviekotlin.utils.SchedulerProvider
import dagger.Module
import dagger.Provides

@Module
class UpcomingFragmentModule {

    @Provides
    internal fun provideUpcomingViewModel(dataManager: DataManager, schedulerProvider: SchedulerProvider)
            : UpcomingViewModel = UpcomingViewModel(dataManager, schedulerProvider)

    @Provides
    internal fun provideUpcomingViewModelProviderFactory(viewModel: UpcomingViewModel)
            : ViewModelProvider.Factory = ViewModelProviderFactory(viewModel)

    @Provides
    internal fun provideUpcomingAdapter(dataManager: DataManager, schedulerProvider: SchedulerProvider)
            : UpcomingAdapter = UpcomingAdapter(ArrayList(), dataManager = dataManager, schedulerProvider = schedulerProvider)

    @Provides
    internal fun provideGridLayoutManager(fragment: UpcomingFragment): GridLayoutManager = GridLayoutManager(fragment.activity, 3)
}