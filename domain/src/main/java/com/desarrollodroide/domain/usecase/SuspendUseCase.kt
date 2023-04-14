package com.desarrollodroide.domain.usecase

interface SuspendUseCase<in Params, out T> {
    suspend fun execute(params: Params) : T
}