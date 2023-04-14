package com.desarrollodroide.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.desarrollodroide.data.local.entity.DummyObjectEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface DummyObjectDao {

  @Query("SELECT * FROM table_dummy_objects")
  fun getDummyObjects(): Flow<List<DummyObjectEntity>>

  @Insert(onConflict = OnConflictStrategy.REPLACE)
  suspend fun saveDummyObjects(carLicenses: List<DummyObjectEntity>)

}