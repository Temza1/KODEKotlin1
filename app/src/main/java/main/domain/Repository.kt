package main.domain

import kotlinx.coroutines.flow.Flow

interface Repository {
    suspend fun getWorkerList() : List<Worker>
}