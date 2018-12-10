package com.fransisco.catalogmoviekotlin.ui.main

import com.fransisco.catalogmoviekotlin.data.DataManager
import com.fransisco.catalogmoviekotlin.ui.base.BaseViewModel
import com.fransisco.catalogmoviekotlin.utils.SchedulerProvider

class MainViewModel constructor(dataManager: DataManager, schedulerProvider: SchedulerProvider) : BaseViewModel<MainNavigator>(dataManager = dataManager, schedulerProvider = schedulerProvider) {


}