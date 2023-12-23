package com.canque.buddly

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.canque.buddly.adapters.ExpenseAdapter
import com.canque.buddly.databinding.FragmentExpensesBinding
import com.canque.buddly.databinding.FragmentHomeBinding
import com.canque.buddly.datastore.SharedPref
import com.canque.buddly.models.Category
import com.canque.buddly.models.Expense

class ExpensesFragment : Fragment() {
    private var _binding: FragmentExpensesBinding? = null
    //private val context: Context = requireContext()
    //private val activity: Activity = requireActivity()

    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentExpensesBinding.inflate(inflater, container, false)
        initiateNav()

        val sharedPref = SharedPref(this.requireContext())
        val expenses = sharedPref.loadExpenseList().toMutableList()
        val categories = sharedPref.loadCategoryList().toMutableList()

        binding.floatingActionButton.setOnClickListener {
            startActivity(Intent(this.requireContext(), AddExpenseActivity::class.java))
            /*expenses.add(Expense(genId(), 100.00, categories[0]))
            expenses.add(Expense(genId(), 200.00, categories[1]))
            expenses.add(Expense(genId(), 300.00, categories[2]))
            sharedPref.saveExpenseList(expenses)*/
            updateBalance()
        }

        /*expenses.clear()
        sharedPref.saveExpenseList(expenses)*/

        val totalExpense = expenses.fold(0.0) { acc, expense ->
            acc + expense.amount
        }
        binding.textViewContent.setText("PHP " + totalExpense)

        binding.expenseList.layoutManager = LinearLayoutManager(this.requireContext())
        binding.expenseList.adapter = ExpenseAdapter(this.requireActivity(), expenses.reversed())

        return binding.root
    }
    private fun updateBalance() {
        val sharedPref = SharedPref(this.requireContext())
        val expenses = sharedPref.loadExpenseList().toMutableList()

        val totalExpense = expenses.fold(0.0) { acc, expense ->
            acc + expense.amount
        }

        sharedPref.totalExpense = totalExpense
        sharedPref.balance -= sharedPref.totalExpense
    }
    private fun initiateNav() {
        binding.topAppBar.setNavigationOnClickListener {
            // Handle navigation icon press
            Toast.makeText(activity, "Feature to be added!", Toast.LENGTH_SHORT).show()

        }

        binding.topAppBar.setOnMenuItemClickListener { menuItem ->
            when (menuItem.itemId) {
                R.id.search -> {
                    // Handle more item (inside overflow menu) press
                    Toast.makeText(activity, "Feature to be added!", Toast.LENGTH_SHORT).show()
                    true
                }
                else -> false
            }
        }
    }
    private fun genId(): String {
        val allowedChars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789"
        return (1..10)
            .map { allowedChars.random() }
            .joinToString("")
    }
}