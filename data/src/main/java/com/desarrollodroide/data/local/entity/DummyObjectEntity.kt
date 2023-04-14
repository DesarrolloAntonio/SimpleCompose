package com.desarrollodroide.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "table_dummy_objects")
data class DummyObjectEntity (
    @PrimaryKey
    val id: Int,
    val userId: Int,
    val title: String,
    val body: String
    )