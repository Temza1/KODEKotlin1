package data.dtoModel

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class WorkerResponce (
    val workers : List<WorkerStateDto>
)