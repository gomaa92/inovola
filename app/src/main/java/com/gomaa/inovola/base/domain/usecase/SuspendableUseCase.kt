package com.gomaa.inovola.base.domain.usecase

interface SuspendableUseCase<I,O> {
    suspend fun execute(input: I?= null): O
}