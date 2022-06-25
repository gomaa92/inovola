package com.gomaa.inovola.features.list_writer.presentation.writers.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.liveData
import androidx.lifecycle.viewModelScope
import com.gomaa.inovola.base.presentation.viewmodel.BaseViewModel
import com.gomaa.inovola.features.list_writer.domain.usecase.GetWritersListUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import javax.inject.Inject

@HiltViewModel
class WritersListViewModel @Inject constructor(private val useCase: GetWritersListUseCase) :
    BaseViewModel<WritersListViewState, WritersListActions, WritersListResult>() {
    override val internalViewState = WritersListViewState.Loading

    private val context = viewModelScope.coroutineContext + Dispatchers.Default

    override fun handle(action: WritersListActions): LiveData<WritersListResult> =
        liveData(context) {
            when (action) {
                is WritersListActions.GetWritersList -> {
                    emit(WritersListResult.Loading)
                    emit(useCase.execute())
                }
            }

        }

    override fun reduce(result: WritersListResult): WritersListViewState {
        return when (result) {
            WritersListResult.Failure -> WritersListViewState.Failure
            WritersListResult.Loading -> WritersListViewState.Loading
            is WritersListResult.Success -> WritersListViewState.Success(response = result.response)
        }
    }
}