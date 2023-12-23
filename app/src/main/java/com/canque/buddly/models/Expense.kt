package com.canque.buddly.models

data class Expense(
    val id: String,
    var amount: Double,
    var category: Category,
)
