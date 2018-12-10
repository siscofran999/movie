package com.fransisco.catalogmoviekotlin.ui.trending

import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class TrendingFragmentProvider {

    @ContributesAndroidInjector(modules = [(TrendingFragmentModule::class)])
    internal abstract fun provideNowPlayingFragmentFactory(): TrendingFragment
}