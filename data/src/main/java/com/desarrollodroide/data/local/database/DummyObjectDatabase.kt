package com.desarrollodroide.data.local.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.desarrollodroide.data.local.dao.DummyObjectDao
import com.desarrollodroide.data.local.entity.DummyObjectEntity

@Database(entities = [DummyObjectEntity::class], version = 1)
abstract class DummyObjectDatabase : RoomDatabase() {

  abstract fun dummyObjectDao(): DummyObjectDao

}