package com.desarrollodroide.simplecompose.domain

import com.desarrollodroide.simplecompose.api.ApiService
import com.desarrollodroide.simplecompose.database.DummyObjectDao
import com.desarrollodroide.simplecompose.model.DummyObject
import javax.inject.Inject

class DummyObjectRepositoryImpl @Inject constructor(
    private val apiService: ApiService,
    private val dummyObjectDao: DummyObjectDao
) : DummyObjectRepository {

    override suspend fun getDummyObjects(): List<DummyObject>{
        val cachedDummyObjects = dummyObjectDao.getDummyObjects()
        val data = try {
            apiService.getDataFromServer()
        }catch (error: Throwable) {
            null
        }
        data?.body()?.let {
            dummyObjectDao.saveDummyObjects(it)
        }
        return data?.body() ?: cachedDummyObjects
    }
}