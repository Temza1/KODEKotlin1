package data.repositoryImpl

import android.app.Activity
import android.app.Application
import data.api.ApiFactory
import data.api.ApiService
import domain.model.Repository
import domain.model.WorkerListState
import domain.model.WorkerState
import mapper.WorkerMapper

class RepositoryImpl(application: Application) : Repository {

    private val apiService = ApiFactory.create()
    private val mapper = WorkerMapper()
    override suspend fun getWorkerList(): List<WorkerState> {
        val workerResponce = apiService.loadWorkers()
        val listDto = workerResponce.workers
        return mapper.mapDtoToDomain(listDto)
    }
}