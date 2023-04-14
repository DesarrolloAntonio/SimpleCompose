package com.desarrollodroide.domain.repository

import com.desarrollodroide.domain.model.DummyObject
import kotlinx.coroutines.flow.Flow
import com.desarrollodroide.domain.model.state.Result

interface DummyObjectRepository {

  fun getDummyObjects(): Flow<Result<out List<DummyObject>?>>

}