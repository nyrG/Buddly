package com.canque.buddly

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import com.canque.buddly.databinding.ActivityAddExpenseBinding
import com.canque.buddly.databinding.ActivityMainBinding
import com.canque.buddly.datastore.SharedPref
import com.google.android.material.textfield.MaterialAutoCompleteTextView
import java.util.Locale.Category

class AddExpenseActivity : AppCompatActivity() {
    private lateinit var binding: ActivityAddExpenseBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        enableEdgeToEdge()
        super.onCreate(savedInstanceState)
        binding = ActivityAddExpenseBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.topAppBar.setNavigationOnClickListener {
            // Handle navigation icon press
            finish()
        }

        val sharedPref = SharedPref(this)
        val categories = sharedPref.loadCategoryList().toMutableList()
        Log.d("Category List", "$categories")
        var selectedCategory = categories[0]
        val categoryNames: Array<String> = categories.map { it.name }.toTypedArray()
        Log.d("Category Array", "$categoryNames")


        //binding.categoryButton.text = selectedCategory.name
        (binding.categoryDropdown as? MaterialAutoCompleteTextView)?.setSimpleItems(categoryNames)
        binding.categoryIcon.setIconResource(selectedCategory.iconResId)
    }
}