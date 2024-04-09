package data

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Receipts(
    @SerialName("hits")
    val receipts: List<ReceiptModel> = emptyList()
)
