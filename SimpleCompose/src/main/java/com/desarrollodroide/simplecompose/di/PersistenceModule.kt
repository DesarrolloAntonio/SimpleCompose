package com.desarrollodroide.simplecompose.di

import android.app.Application
import androidx.room.Room
import com.desarrollodroide.simplecompose.database.DummyObjectDao
import com.desarrollodroide.simplecompose.database.DummyObjectDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object PersistenceModule {

  @Provides
  @Singleton
  fun provideAppDatabase(application: Application): DummyObjectDatabase {
    return Room
      .databaseBuilder(
        application,
        DummyObjectDatabase::class.java,
        "database.db"
      )
      .fallbackToDestructiveMigration()
      .build()
  }

  @Provides
  @Singleton
  fun provideDummyObjetDao(appDatabase: DummyObjectDatabase): DummyObjectDao {
    return appDatabase.dummyObjectDao()
  }
}
