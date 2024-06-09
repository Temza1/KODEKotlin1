package main.data.repositoryImpl

import android.app.Application
import android.util.Log
import main.data.api.ApiFactory
import main.domain.Repository
import main.domain.WorkerState
import main.data.mapper.WorkerMapper

class RepositoryImpl(application: Application) : Repository {

    companion object {
        const val LOG_REP_IMPL = "RepositoryImpl"
    }

    private val apiService = ApiFactory.create()
    private val mapper = WorkerMapper()
    override suspend fun getWorkerList(): List<WorkerState> {
        val workerResponce = apiService.loadWorkers()
        if (workerResponce.workers.isEmpty()) {
            Log.d(LOG_REP_IMPL,"список пуст")
        }
    return mapper.mapDtoToDomain(workerResponce.workers)
    }

}