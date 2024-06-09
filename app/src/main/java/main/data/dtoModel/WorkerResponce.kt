package main.data.dtoModel

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class WorkerResponce (
    @SerializedName("items")
    @Expose
    val workers : List<WorkerStateDto>
)