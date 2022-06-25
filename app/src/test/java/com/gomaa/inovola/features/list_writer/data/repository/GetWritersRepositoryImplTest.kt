package com.gomaa.inovola.features.list_writer.data.repository

import com.gomaa.inovola.base.data.remote.NetworkResponse
import com.gomaa.inovola.features.list_writer.data.model.ListWritersResponse
import com.gomaa.inovola.features.list_writer.data.remote.GetWriterRemoteDataSource
import com.gomaa.inovola.features.list_writer.domain.repository.GetWritersRepository
import kotlinx.coroutines.runBlocking
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations

class GetWritersRepositoryImplTest {
    private lateinit var repository: GetWritersRepository

    @Mock
    lateinit var remoteDataSource: GetWriterRemoteDataSource

    @Before
    fun setUp() {
        MockitoAnnotations.openMocks(this)
        repository = GetWritersRepositoryImpl(remoteDataSource)
    }

    @Test
    fun returnGetWritersSuccess() {
        runBlocking {
            val networkResponse = NetworkResponse.Success(ListWritersResponse(arrayListOf()))
            Mockito.`when`(remoteDataSource.getWritersList()).thenReturn(networkResponse)
            Assert.assertEquals(networkResponse, repository.getWritersList())
        }
    }
}