package com.fineteklabs.spacetutorial

import com.fineteklabs.spacetutorial.cache.Database
import com.fineteklabs.spacetutorial.cache.DatabaseDriverFactory
import com.fineteklabs.spacetutorial.entity.RocketLaunch
import com.fineteklabs.spacetutorial.network.NetworkResult
import com.fineteklabs.spacetutorial.network.SpaceXApi


class SpaceXSDK(databaseDriverFactory: DatabaseDriverFactory, val api: SpaceXApi) {
    private val database = Database(databaseDriverFactory)

    @Throws(Exception::class)
    suspend fun getLaunches(forceReload: Boolean): List<RocketLaunch> {
        val cachedLaunches = database.getAllLaunches()
        return (if (cachedLaunches.isNotEmpty() && !forceReload) {
            cachedLaunches
        } else {
           when(val res = api.getAllLaunches()){
               is NetworkResult.Success -> res.data
               is NetworkResult.HttpError ->  emptyList()
               is NetworkResult.NetworkError ->  emptyList()
               is NetworkResult.SerializationError -> emptyList()
               is NetworkResult.UnknownError -> emptyList()
           }
        })
    }

}
