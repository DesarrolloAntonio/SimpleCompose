package com.desarrollodroide.simplecompose.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.desarrollodroide.simplecompose.model.DummyObject

@Database(entities = [DummyObject::class], version = 1)
abstract class DummyObjectDatabase : RoomDatabase() {

  abstract fun dummyObjectDao(): DummyObjectDao

}