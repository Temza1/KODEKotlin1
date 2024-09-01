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
) {
    fun doesMatchSearchQuery(query : String) : Boolean {
        val combinations = listOf(
            "$firstName$lastName",
            "$firstName +$lastName",
            "${firstName.first()} ${lastName.first()}"
        )
        return combinations.any {
            it.contains(query,ignoreCase = true)
        }
    }

    fun doesMatchSearchQueryEquals(query : String) : Boolean {
        val combinations = listOf(
            lastName,
            firstName,
            "$firstName +$lastName",
            "${firstName.first()} ${lastName.first()}"
        )
        return combinations.any {
            it.equals(query,ignoreCase = true)
        }
    }

}
