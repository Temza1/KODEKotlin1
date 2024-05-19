package data.repositoryImpl

import android.app.Activity
import android.app.Application
import data.api.ApiFactory
import data.api.ApiService
import domain.model.Repository
import domain.model.WorkerListState
import domain.model.WorkerState

class RepositoryImpl(application: Application) : Repository {

    private val apiService = ApiFactory.create()
    override suspend fun getWorkerList(): List<WorkerState> {
        return apiService.loadWorkers()
    }
}