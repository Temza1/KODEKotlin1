package main.data.api

import kotlinx.coroutines.flow.Flow
import main.data.dtoModel.WorkerResponce
import main.data.mapper.WorkerMapper
import retrofit2.http.GET
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
interface ApiService {
    @GET("users")
    suspend fun loadWorkers() : WorkerResponce

}