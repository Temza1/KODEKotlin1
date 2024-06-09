package main.data.mapper

import main.data.dtoModel.WorkerStateDto
import main.domain.WorkerState

class WorkerMapper {

    fun mapDtoToDomain(listDto : List<WorkerStateDto>?) : List<WorkerState> {

        val listDomain : List<WorkerState> = emptyList()

        listDto?.forEach {

            val workerState = WorkerState(
                it.id,
                it.avatarUrl,
                it.firstName,
                it.lastName,
                it.department,
                it.phone,
                it.position,
                it.userTag,
                it.birthday
            )

            listDomain.plus(workerState)
        }

        return listDomain
    }
}