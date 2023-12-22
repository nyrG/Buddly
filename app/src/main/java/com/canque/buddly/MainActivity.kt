package com.canque.buddly

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import com.canque.buddly.databinding.ActivityMainBinding
import com.google.android.material.shape.MaterialShapeDrawable

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        enableEdgeToEdge()
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.topAppBar.setNavigationOnClickListener {
            // Handle navigation icon press
            Toast.makeText(this, "Sorry, this feature is incomplete.", Toast.LENGTH_SHORT).show()
        }

        binding.topAppBar.setOnMenuItemClickListener { menuItem ->
            when (menuItem.itemId) {
                R.id.notification -> {
                    // Handle more item (inside overflow menu) press
                    Toast.makeText(this, "Sorry, this feature is incomplete.", Toast.LENGTH_SHORT).show()
                    true
                }
                else -> false
            }
        }
    }

}