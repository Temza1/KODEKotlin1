package main.data.api

import com.google.gson.Gson
import main.data.mapper.WorkerMapper
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Inject

class ApiFactory @Inject constructor() {

    companion object {

        private const val BASE_URL =
            "https://stoplight.io/mocks/kode-education/trainee-test/25143926/"

        fun create(): ApiService {

            val retrofit: Retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()

            return retrofit.create(ApiService::class.java)
        }

    }


}