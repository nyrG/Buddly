package com.canque.buddly.datastore

import android.content.Context
import com.canque.buddly.constants.Constants
import com.canque.buddly.models.Budget
import com.canque.buddly.models.Category
import com.canque.buddly.models.Expense
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class SharedPref(context: Context) {

    private val sharedPref = context
        .getSharedPreferences(Constants.GENERAL, Context.MODE_PRIVATE)

    private val gson = Gson()

    var balance: Double
        set(balance) = sharedPref.edit()
            .putFloat(Constants.PARAM_BALANCE, balance.toFloat()).apply()
        get() = sharedPref
            .getFloat(Constants.PARAM_BALANCE, 0.00F).toDouble()

    var totalExpense: Double
        set(totalExpense) = sharedPref.edit()
            .putFloat(Constants.PARAM_TOTAL_EXPENSE, totalExpense.toFloat()).apply()
        get() = sharedPref
            .getFloat(Constants.PARAM_TOTAL_EXPENSE, 0.00F).toDouble()

    fun saveExpenseList(dataList: List<Expense>) {
        val json = gson.toJson(dataList)
        sharedPref.edit().putString(Constants.PARAM_EXPENSE_LIST, json).apply()
    }
    fun loadExpenseList(): List<Expense> {
        val json = sharedPref.getString(Constants.PARAM_EXPENSE_LIST, null)
        return if (json != null) {
            val type = object : TypeToken<List<Expense>>() {}.type
            gson.fromJson(json, type)
        } else {
            emptyList()
        }
    }

    fun saveBudgetList(dataList: List<Budget>) {
        val json = gson.toJson(dataList)
        sharedPref.edit().putString(Constants.PARAM_BUDGET_LIST, json).apply()
    }
    fun loadBudgetList(): List<Budget> {
        val json = sharedPref.getString(Constants.PARAM_BUDGET_LIST, null)
        return if (json != null) {
            val type = object : TypeToken<List<Budget>>() {}.type
            gson.fromJson(json, type)
        } else {
            emptyList()
        }
    }

    fun saveCategoryList(dataList: List<Category>) {
        val json = gson.toJson(dataList)
        sharedPref.edit().putString(Constants.PARAM_CATEGORY_LIST, json).apply()
    }
    fun loadCategoryList(): List<Category> {
        val json = sharedPref.getString(Constants.PARAM_CATEGORY_LIST, null)
        return if (json != null) {
            val type = object : TypeToken<List<Category>>() {}.type
            gson.fromJson(json, type)
        } else {
            emptyList()
        }
    }
}