package com.desarrollodroide.simplecompose.di

import com.desarrollodroide.simplecompose.domain.DummyObjectRepository
import com.desarrollodroide.simplecompose.api.ApiService
import com.desarrollodroide.simplecompose.database.DummyObjectDao
import com.desarrollodroide.simplecompose.domain.DummyObjectRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
object RepositoryModule {

    @Provides
    @ViewModelScoped
    fun provideMainRepository(
        apiService: ApiService,
        dummyObjectDao: DummyObjectDao
    ): DummyObjectRepository {
        return DummyObjectRepositoryImpl(apiService, dummyObjectDao)
    }

}
