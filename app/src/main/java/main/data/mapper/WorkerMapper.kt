package main.data.mapper

import main.data.api.ApiService
import main.data.dtoModel.WorkerStateDto
import main.domain.Worker
import javax.inject.Inject

class WorkerMapper @Inject constructor(){

    fun mapDtoToDomain(listDto: List<WorkerStateDto>?): List<Worker> {

        val listDomain = ArrayList<Worker>()

        listDto?.forEach {
            val worker1 = Worker(
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

            listDomain.add(worker1)
        }

        return listDomain
    }
}