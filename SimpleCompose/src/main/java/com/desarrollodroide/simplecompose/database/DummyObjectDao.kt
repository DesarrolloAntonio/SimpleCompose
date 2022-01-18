package com.desarrollodroide.simplecompose.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.desarrollodroide.simplecompose.model.DummyObject

@Dao
interface DummyObjectDao {

  @Insert(onConflict = OnConflictStrategy.REPLACE)
  suspend fun saveDummyObjects(carLicenses: List<DummyObject>)

  @Query("SELECT * FROM table_dummy_objects")
  suspend fun getDummyObjects(): List<DummyObject>

}