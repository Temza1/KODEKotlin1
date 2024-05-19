package domain.model

interface Repository {
    suspend fun getWorkerList() : List<WorkerState>
}