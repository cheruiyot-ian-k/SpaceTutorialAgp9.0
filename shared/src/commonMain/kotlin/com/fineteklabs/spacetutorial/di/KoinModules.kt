package com.fineteklabs.spacetutorial.di

import com.fineteklabs.spacetutorial.network.SpaceXApi
import com.fineteklabs.spacetutorial.network.createClientFactory
import org.koin.dsl.module


val networkDataModule = module {
    single {
        createClientFactory()
    }
    single<SpaceXApi> { SpaceXApi(get()) }
}