package main.domain

interface Repository {
    suspend fun getWorkerList() : List<WorkerState>
}