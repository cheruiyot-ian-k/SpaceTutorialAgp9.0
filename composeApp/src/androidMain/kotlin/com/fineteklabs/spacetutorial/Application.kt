package com.fineteklabs.spacetutorial

import android.app.Application
import com.fineteklabs.spacetutorial.di.appModule
import com.fineteklabs.spacetutorial.di.networkDataModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.GlobalContext.startKoin

class MainApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@MainApplication)
            modules(networkDataModule, appModule)
        }
    }
}