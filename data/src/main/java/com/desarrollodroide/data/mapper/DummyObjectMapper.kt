package com.desarrollodroide.data.mapper

import com.desarrollodroide.domain.model.DummyObject
import com.desarrollodroide.data.remote.dto.DummyObjectDTO
import com.desarrollodroide.data.local.entity.DummyObjectEntity

fun DummyObjectEntity.toDomainModel() = DummyObject(
    id = id,
    userId = userId,
    title = title,
    body = body
)

fun DummyObjectDTO.toEntityModel() = DummyObjectEntity(
    id = id ?: 0,
    userId = userId ?: 0,
    title = title ?: "",
    body = body ?: ""
)