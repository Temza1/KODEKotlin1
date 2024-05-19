package data.api

import domain.model.WorkerListState
import domain.model.WorkerState
import retrofit2.http.GET

interface ApiService {

    @GET("users")
    suspend fun loadWorkers() : List<WorkerState>

}