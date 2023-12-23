package com.canque.buddly.models

data class Budget(
    val id: String,
    var name: String,
    var amount: Double,
    var category: Category,
)
