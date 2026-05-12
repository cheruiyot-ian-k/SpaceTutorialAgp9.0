package com.fineteklabs.spacetutorial.di

import com.fineteklabs.spacetutorial.RocketLaunchViewModel
import com.fineteklabs.spacetutorial.SpaceXSDK
import com.fineteklabs.spacetutorial.cache.AndroidDatabaseDriverFactory
import org.koin.android.ext.koin.androidContext
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module


val appModule = module {
    single<SpaceXSDK> {
        SpaceXSDK(
            databaseDriverFactory = AndroidDatabaseDriverFactory(
                androidContext()
            ), api = get()
        )
    }
    viewModel { RocketLaunchViewModel(sdk = get()) }
}