package main.data.repository

import android.app.Application
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import main.data.api.ApiFactory
import main.data.mapper.WorkerMapper
import main.domain.Repository
import main.domain.Worker

class RepositoryImpl(application: Application) : Repository {

    companion object {
        const val LOG_REP_IMPL = "RepositoryImpl"
    }

    private val apiService = ApiFactory.create()
    private val mapper = WorkerMapper()
    override suspend fun getWorkerList(): List<Worker> {
        val workerResponce = apiService.loadWorkers()
        return mapper.mapDtoToDomain(workerResponce.workers)
    }


}