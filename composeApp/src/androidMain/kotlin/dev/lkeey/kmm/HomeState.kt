package dev.lkeey.kmm

import data.ReceiptModel

data class HomeState (
    val receipts: List<ReceiptModel> = emptyList()
)