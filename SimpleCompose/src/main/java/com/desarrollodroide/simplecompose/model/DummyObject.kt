package com.desarrollodroide.simplecompose.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "table_dummy_objects")
data class DummyObject (
    @PrimaryKey val id: Int,
    val userId: Int,
    val title: String,
    val body: String)