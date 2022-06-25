package com.gomaa.inovola.features.list_writer.domain.usecase

import com.gomaa.inovola.base.domain.usecase.SuspendableUseCase
import com.gomaa.inovola.features.list_writer.domain.repository.GetWritersRepository
import com.gomaa.inovola.features.list_writer.presentation.writers.viewmodel.WritersListResult
import com.gomaa.inovola.base.data.remote.NetworkResponse
import dagger.hilt.android.scopes.ViewModelScoped
import javax.inject.Inject

@ViewModelScoped
class GetWritersListUseCase @Inject constructor(private val repository: GetWritersRepository) :
    SuspendableUseCase<Unit, WritersListResult> {
    override suspend fun execute(input: Unit?): WritersListResult {
        return when (val response = repository.getWritersList()) {
            is NetworkResponse.Success -> {
                WritersListResult.Success(response.data)
            }
            is NetworkResponse.Failure -> {
                WritersListResult.Failure
            }
        }
    }

}