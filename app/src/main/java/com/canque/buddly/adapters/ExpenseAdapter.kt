package com.canque.buddly.adapters

import android.app.Activity
import android.app.Dialog
import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.view.Gravity
import android.view.LayoutInflater
import android.view.ViewGroup
import android.view.Window
import android.widget.LinearLayout
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.RecyclerView
import com.canque.buddly.databinding.ItemExpenseBinding
import com.canque.buddly.models.Expense

class ExpenseAdapter(
    private val activity: FragmentActivity,
    private val expenseList: List<Expense>,
): RecyclerView.Adapter<ExpenseAdapter.ExpenseViewHolder>() {

    class ExpenseViewHolder(
        private val activity: Activity,
        private val binding: ItemExpenseBinding,
    ): RecyclerView.ViewHolder(binding.root) {
        fun bind(expense: Expense) {
            binding.category.text = expense.category.name
            binding.categoryIcon.setImageResource(expense.category.iconResId)
            binding.amount.text = "PHP " + expense.amount.toString()
            //binding.item.setOnClickListener {}

        }
        /*private fun showDialog(expense: Expense, context: Context) {
            val sheet = Dialog(context)
            sheet.requestWindowFeature(Window.FEATURE_NO_TITLE)
            sheet.setContentView(R.layout.bottom_sheet)

            val deleteLayout: LinearLayout = sheet.findViewById(R.id.layoutDelete)

            deleteLayout.setOnClickListener() {
                Toast.makeText(context, "This is a standard AlertDialog.", Toast.LENGTH_SHORT).show()
                val builder = androidx.appcompat.app.AlertDialog.Builder(context, R.style.RoundedCornersAlertDialog)
                builder
                    .setTitle("Delete task?")
                    .setMessage("This can’t be undone and it will be removed from your to-do list.")
                    .setPositiveButton("Delete"){ dialog, _ ->
                        val id = expense.id
                        val sharedPref = SharedPref(context)
                        var tasks = sharedPref.loadTaskList().toMutableList()

                        tasks = tasks.filter { it.id != id }.toMutableList()
                        sharedPref.saveTaskList(tasks)
                    }
                    .setNegativeButton("Cancel"){dialog,_ ->
                        dialog.dismiss()
                    }
                val alertDialog = builder.create()
                alertDialog.setOnShowListener {
                    alertDialog.getButton(androidx.appcompat.app.AlertDialog.BUTTON_POSITIVE)
                        ?.setTextColor(ContextCompat.getColor(context, android.R.color.black))
                    alertDialog.getButton(androidx.appcompat.app.AlertDialog.BUTTON_NEGATIVE)
                        ?.setTextColor(ContextCompat.getColor(context, android.R.color.black))
                }
                alertDialog.show()
                sheet.dismiss()
            }

            sheet.show()
            sheet.window?.setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT)
            sheet.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
            sheet.window?.attributes?.windowAnimations = R.style.DialogAnimation
            sheet.window?.setGravity(Gravity.BOTTOM)
        }*/
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ExpenseViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemExpenseBinding.inflate(
            inflater,
            parent,
            false,
        )
        return ExpenseViewHolder(activity, binding)
    }

    override fun getItemCount() = expenseList.size

    override fun onBindViewHolder(holder: ExpenseViewHolder, position: Int) {
        holder.bind(expenseList[position])
    }
}