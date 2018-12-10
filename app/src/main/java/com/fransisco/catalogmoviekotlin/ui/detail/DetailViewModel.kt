package com.fransisco.catalogmoviekotlin.ui.detail

import com.fransisco.catalogmoviekotlin.data.DataManager
import com.fransisco.catalogmoviekotlin.ui.base.BaseViewModel
import com.fransisco.catalogmoviekotlin.utils.SchedulerProvider

class DetailViewModel constructor(dataManager: DataManager, schedulerProvider: SchedulerProvider) : BaseViewModel<DetailNavigator>(dataManager = dataManager, schedulerProvider = schedulerProvider) {
}