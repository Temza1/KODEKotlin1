package main.domain

import kotlinx.coroutines.flow.Flow
import main.data.api.ApiService
import main.data.mapper.WorkerMapper
import javax.inject.Inject

interface Repository  {
    suspend fun getWorkerList(): List<Worker>
}