package com.fransisco.catalogmoviekotlin.di.builder

import com.fransisco.catalogmoviekotlin.ui.main.MainActivity
import com.fransisco.catalogmoviekotlin.ui.main.MainActivityModule
import com.fransisco.catalogmoviekotlin.ui.nowPlaying.NowPlayingFragmentProvider
import com.fransisco.catalogmoviekotlin.ui.upcoming.UpcomingFragmentProvider
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuilder {

    @ContributesAndroidInjector(modules = [(MainActivityModule::class), (NowPlayingFragmentProvider::class), (UpcomingFragmentProvider::class)])
    abstract fun bindMainActivity(): MainActivity
}