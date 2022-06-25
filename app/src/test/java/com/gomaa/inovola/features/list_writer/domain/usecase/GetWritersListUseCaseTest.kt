package com.gomaa.inovola.features.list_writer.domain.usecase

import com.gomaa.inovola.base.data.remote.NetworkResponse
import com.gomaa.inovola.features.list_writer.data.model.ListWritersResponse
import com.gomaa.inovola.features.list_writer.domain.repository.GetWritersRepository
import com.gomaa.inovola.features.list_writer.presentation.writers.viewmodel.WritersListResult
import kotlinx.coroutines.runBlocking
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.MockitoAnnotations
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class GetWritersListUseCaseTest {
    private lateinit var useCase: GetWritersListUseCase

    @Mock
    private lateinit var repository: GetWritersRepository

    @Before
    fun setUp() {
        MockitoAnnotations.openMocks(this)
        useCase = GetWritersListUseCase(repository)
    }

    @Test
    fun `get writer data return success`() = runBlocking {

        whenever(repository.getWritersList()).thenReturn(
            NetworkResponse.Success(arrayListOf())
        )
        val expectedRes =
            WritersListResult.Success(ListWritersResponse(arrayListOf()))
        Assert.assertEquals(
            expectedRes,
            useCase.execute(Unit)
        )
    }

}