package com.canque.buddly

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.canque.buddly.databinding.ActivityMainBinding
import com.canque.buddly.datastore.SharedPref
import com.canque.buddly.models.Category
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.shape.MaterialShapeDrawable

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        enableEdgeToEdge()
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        populateCategories()

//        val sharedPref = SharedPref(this)
//        val categories = sharedPref.loadCategoryList().toMutableList()
//        categories.clear()
//        sharedPref.saveCategoryList(categories)

        //Bottom Navigation Controller
        val navController = findNavController(R.id.fragment_view)
        binding.bottomNavigation.setupWithNavController(navController)

    }
    private fun populateCategories() {
        val sharedPref = SharedPref(this)
        val categories = sharedPref.loadCategoryList().toMutableList()
        if (categories.isEmpty()) {
            categories.add(Category("1", "Food and Drinks", R.drawable.food_and_drinks))
            categories.add(Category("2", "Shopping", R.drawable.shopping))
            categories.add(Category("3", "Trasportation", R.drawable.transportation))
            categories.add(Category("4", "Vehicle", R.drawable.vehicle))
            categories.add(Category("5", "Technology", R.drawable.technology))
        }
        sharedPref.saveCategoryList(categories)
    }
}