package com.desarrollodroide.simplecompose.di

import com.desarrollodroide.data.error.ErrorHandlerImpl
import com.desarrollodroide.data.local.dao.DummyObjectDao
import com.desarrollodroide.data.remote.api.ApiService
import com.desarrollodroide.data.repository.DummyObjectRepositoryImpl
import com.desarrollodroide.domain.model.state.ErrorHandler
import com.desarrollodroide.domain.repository.DummyObjectRepository
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
abstract class RepositoryModule {

    @Binds
    abstract fun bindErrorHandler(errorHandlerImpl: ErrorHandlerImpl): ErrorHandler

    companion object {
        @Provides
        @ViewModelScoped
        fun provideMainRepository2(
            apiService: ApiService,
            dummyObjectDao: DummyObjectDao,
            errorHandler: ErrorHandler
        ): DummyObjectRepository {
            return DummyObjectRepositoryImpl(apiService, dummyObjectDao, errorHandler)
        }
    }
}
