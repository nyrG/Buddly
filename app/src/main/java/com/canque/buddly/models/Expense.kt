package com.canque.buddly.models

data class Expense(
    val id: String,
    var amount: Float,
    var category: Category,
    var dueDate: String?,
)
