package main.data.mapper

import main.data.dtoModel.WorkerStateDto
import main.domain.WorkerState

class WorkerMapper {

    fun mapDtoToDomain(listDto: List<WorkerStateDto>?): List<WorkerState> {

        val listDomain = ArrayList<WorkerState>()

        listDto?.forEach {
            val workerState1 = WorkerState(
                id = it.id,
                avatarUrl = "https://pic.rutubelist.ru/user/fd/76/fd766d07ff98aae9c6ef20cf3c5312d2.jpg",
                firstName = it.firstName,
                lastName = it.lastName,
                userTag = it.userTag,
                department = it.department,
                position = it.position,
                birthday = it.birthday,
                phone = it.phone
            )

            listDomain.add(workerState1)
        }

        return listDomain
    }
}