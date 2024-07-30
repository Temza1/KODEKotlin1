package main.data.api

import kotlinx.coroutines.flow.Flow
import main.data.dtoModel.WorkerResponce
import retrofit2.http.GET

interface ApiService {
    @GET("users")
    suspend fun loadWorkers() : WorkerResponce

}