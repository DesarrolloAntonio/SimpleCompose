package com.desarrollodroide.simplecompose.domain

import com.desarrollodroide.simplecompose.model.DummyObject

interface DummyObjectRepository {
  suspend fun getDummyObjects(): List<DummyObject>
}