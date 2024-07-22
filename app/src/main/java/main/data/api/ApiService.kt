package main.data.api

import main.data.dtoModel.WorkerResponce
import retrofit2.http.GET

interface ApiService {
    @GET("users")
    suspend fun loadWorkers() : WorkerResponce

}