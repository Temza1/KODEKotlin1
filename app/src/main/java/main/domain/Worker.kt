package main.domain

import androidx.compose.runtime.Immutable


data class Worker(
    val id : String,
    val avatarUrl : String,
    val firstName : String,
    val lastName : String,
    val userTag : String,
    val department : String,
    val position : String,
    val birthday : String,
    val phone : String
)
