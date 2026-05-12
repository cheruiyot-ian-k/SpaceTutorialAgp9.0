package com.fineteklabs.spacetutorial.di

import com.fineteklabs.spacetutorial.SpaceXSDK
import com.fineteklabs.spacetutorial.cache.AndroidDatabaseDriverFactory
import com.fineteklabs.spacetutorial.network.SpaceXApi
import org.koin.dsl.module

//val appModule = module {
//    single<SpaceXApi> { SpaceXApi() }
//    single<SpaceXSDK> {
//        SpaceXSDK(
//            databaseDriverFactory = AndroidDatabaseDriverFactory(
//                androidContext()
//            ), api = get()
//        )
//    }
//}