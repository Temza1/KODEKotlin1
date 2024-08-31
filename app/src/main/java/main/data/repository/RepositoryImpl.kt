package main.data.repository

import android.app.Application
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import main.data.api.ApiFactory
import main.data.api.ApiService
import main.data.mapper.WorkerMapper
import main.domain.Repository
import main.domain.Worker
import java.security.Provider
import javax.inject.Inject

class RepositoryImpl @Inject constructor(
    private val apiService : ApiService,
    private val mapper: WorkerMapper
) : Repository {

    companion object {
        const val LOG_REP_IMPL = "RepositoryImpl"
    }

    override suspend fun getWorkerList(): List<Worker> {
        val workerResponce = apiService.loadWorkers()
        return mapper.mapDtoToDomain(workerResponce.workers)
    }


}