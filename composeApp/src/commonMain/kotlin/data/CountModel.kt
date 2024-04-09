package data

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class CountModel(
    @SerialName("count")
    val count: Int? = null,
)
