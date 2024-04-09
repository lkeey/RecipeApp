package data

import kotlinx.serialization.Serializable

@Serializable
data class Response(
    val result: CountModel? = null
)
