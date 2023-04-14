package com.desarrollodroide.domain.usecase

import com.desarrollodroide.domain.model.DummyObject
import com.desarrollodroide.domain.repository.DummyObjectRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.mapNotNull
import javax.inject.Inject
import com.desarrollodroide.domain.model.state.Result

class GetDummyObjectsUseCase @Inject constructor(
    private val dummyObjectRepository: DummyObjectRepository,
) : UseCase<Unit,Flow<Result<List<DummyObject>?>>> {

    override fun execute(params: Unit): Flow<Result<List<DummyObject>?>> {
        return dummyObjectRepository.getDummyObjects().mapNotNull { response ->
            val result = response.data
            return@mapNotNull when (response) {
                is Result.Success -> Result.Success(result)
                is Result.Error -> Result.Error(response.error, result)
                is Result.Loading -> Result.Loading(result)
            }
        }
    }
}