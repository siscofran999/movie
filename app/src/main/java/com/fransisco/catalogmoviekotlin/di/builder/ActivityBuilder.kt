package com.fransisco.catalogmoviekotlin.di.builder

import com.fransisco.catalogmoviekotlin.ui.detail.DetailActivity
import com.fransisco.catalogmoviekotlin.ui.detail.DetailActivityModule
import com.fransisco.catalogmoviekotlin.ui.main.MainActivity
import com.fransisco.catalogmoviekotlin.ui.main.MainActivityModule
import com.fransisco.catalogmoviekotlin.ui.trending.TrendingFragmentProvider
import com.fransisco.catalogmoviekotlin.ui.topRated.TopRatedFragmentProvider
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuilder {

    @ContributesAndroidInjector(modules = [(MainActivityModule::class), (TrendingFragmentProvider::class), (TopRatedFragmentProvider::class)])
    abstract fun bindMainActivity(): MainActivity

    @ContributesAndroidInjector(modules = [DetailActivityModule::class])
    abstract fun bindDetailActivity(): DetailActivity

}