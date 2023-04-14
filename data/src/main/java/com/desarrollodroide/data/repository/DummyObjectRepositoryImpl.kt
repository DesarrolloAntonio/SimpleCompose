package com.desarrollodroide.data.repository

import com.desarrollodroide.data.remote.api.ApiService
import com.desarrollodroide.data.local.dao.DummyObjectDao
import com.desarrollodroide.data.mapper.toDomainModel
import com.desarrollodroide.data.remote.dto.DummyObjectDTO
import com.desarrollodroide.data.mapper.toEntityModel
import com.desarrollodroide.domain.model.DummyObject
import com.desarrollodroide.domain.model.state.ErrorHandler
import com.desarrollodroide.domain.repository.DummyObjectRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class DummyObjectRepositoryImpl @Inject constructor(
    private val apiService: ApiService,
    private val dummyObjectDao: DummyObjectDao,
    private val errorHandler: ErrorHandler,
) : DummyObjectRepository {
    override fun getDummyObjects() = object :
        NetworkBoundResource<List<DummyObjectDTO>, List<DummyObject>>(errorHandler = errorHandler) {
        override suspend fun saveRemoteData(response: List<DummyObjectDTO>) {
            dummyObjectDao.saveDummyObjects(response.map { it.toEntityModel() })
        }

        override fun fetchFromLocal() = dummyObjectDao.getDummyObjects().map {
            it.map { it.toDomainModel() }
        }

        override suspend fun fetchFromRemote() = apiService.getDataFromServer()

        override fun shouldFetch(data: List<DummyObject>?) = true // Override value (e.g. data.isEmpty())

    }.asFlow().flowOn(Dispatchers.IO)
}