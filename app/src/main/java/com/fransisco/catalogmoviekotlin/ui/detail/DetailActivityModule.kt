package com.fransisco.catalogmoviekotlin.ui.detail

import com.fransisco.catalogmoviekotlin.data.DataManager
import com.fransisco.catalogmoviekotlin.utils.SchedulerProvider
import dagger.Module
import dagger.Provides

@Module
class DetailActivityModule {

    @Provides
    internal fun provideDetailViewModel(dataManager: DataManager, schedulerProvider: SchedulerProvider)
            : DetailViewModel = DetailViewModel(dataManager, schedulerProvider)

}