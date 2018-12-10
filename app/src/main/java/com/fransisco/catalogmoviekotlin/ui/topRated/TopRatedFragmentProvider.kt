package com.fransisco.catalogmoviekotlin.ui.topRated

import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class TopRatedFragmentProvider {

    @ContributesAndroidInjector(modules = [(TopRatedFragmentModule::class)])
    internal abstract fun provideUpcomingFragmentFactory(): TopRatedFragment
}