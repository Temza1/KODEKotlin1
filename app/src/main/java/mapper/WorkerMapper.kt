package mapper

import data.dtoModel.WorkerStateDto
import domain.model.WorkerState

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