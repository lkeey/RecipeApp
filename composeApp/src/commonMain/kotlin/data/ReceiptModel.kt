package data

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Receipt(
    @SerialName("label")
    val name: String? = null,
    @SerialName("image")
    val image: String? = null,
)

@Serializable
data class ReceiptModel(
    @SerialName("recipe")
    val recipe: Receipt? = null,
)