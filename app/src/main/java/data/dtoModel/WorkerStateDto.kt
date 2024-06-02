package data.dtoModel

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class WorkerStateDto(

    @SerializedName("ID")
    @Expose
    val id : String,
    @SerializedName("AVATAR")
    @Expose
    val avatarUrl : String,
    @SerializedName("FIRSTNAME")
    @Expose
    val firstName : String,
    @SerializedName("LASTNAME")
    @Expose
    val lastName : String,
    @SerializedName("USERTAG")
    @Expose
    val userTag : String,
    @SerializedName("DEPARTAMENT")
    @Expose
    val department : String,
    @SerializedName("POSITION")
    @Expose
    val position : String,
    @SerializedName("BIRTHDAY")
    @Expose
    val birthday : String,
    @SerializedName("PHONE")
    @Expose
    val phone : String
)
