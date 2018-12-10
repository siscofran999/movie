package com.fransisco.catalogmoviekotlin.di.module

import android.app.Application
import android.content.Context
import com.fransisco.catalogmoviekotlin.BuildConfig
import com.fransisco.catalogmoviekotlin.data.AppDataManager
import com.fransisco.catalogmoviekotlin.data.DataManager
import com.fransisco.catalogmoviekotlin.data.network.ApiHelper
import com.fransisco.catalogmoviekotlin.data.network.AppApiHelper
import com.fransisco.catalogmoviekotlin.data.preferences.AppPreferenceHelper
import com.fransisco.catalogmoviekotlin.data.preferences.PreferenceHelper
import com.fransisco.catalogmoviekotlin.utils.AppConstants
import com.fransisco.catalogmoviekotlin.utils.SchedulerProvider
import com.fransisco.iniBolaku.di.ApiKeyInfo
import com.fransisco.iniBolaku.di.PreferenceInfo
import dagger.Module
import dagger.Provides
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Singleton


@Module
class AppModule {

    @Provides
    @Singleton
    internal fun provideContext(application: Application): Context = application

    @Provides
    @ApiKeyInfo
    internal fun provideApiKey(): String = BuildConfig.API_KEY

    @Provides
    @PreferenceInfo
    internal fun provideprefFileName(): String = AppConstants.PREF_NAME

    @Provides
    @Singleton
    internal fun providePrefHelper(appPreferenceHelper: AppPreferenceHelper): PreferenceHelper = appPreferenceHelper

    @Provides
    @Singleton
    internal fun provideApiHelper(appApiHelper: AppApiHelper): ApiHelper = appApiHelper

    @Provides
    @Singleton
    internal fun provideDataManager(appDataManager: AppDataManager): DataManager = appDataManager

    @Provides
    internal fun provideCompositeDisposable(): CompositeDisposable = CompositeDisposable()

    @Provides
    internal fun provideSchedulerProvider(): SchedulerProvider = SchedulerProvider()
}