package data.api

import data.dtoModel.WorkerResponce
import data.dtoModel.WorkerStateDto
import domain.model.WorkerListState
import domain.model.WorkerState
import retrofit2.http.GET

interface ApiService {

    @GET("users")
    suspend fun loadWorkers() : WorkerResponce

}