package com.fransisco.catalogmoviekotlin.ui.main

import com.fransisco.catalogmoviekotlin.data.DataManager
import com.fransisco.catalogmoviekotlin.utils.SchedulerProvider
import dagger.Module
import dagger.Provides

@Module
class MainActivityModule {

    @Provides
    internal fun provideMainViewModel(dataManager: DataManager, schedulerProvider: SchedulerProvider)
            : MainViewModel = MainViewModel(dataManager, schedulerProvider)
}