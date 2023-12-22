package com.canque.buddly.models

data class Budget(
    val id: String,
    var name: String,
    var amount: Float,
    var category: Category,
)
