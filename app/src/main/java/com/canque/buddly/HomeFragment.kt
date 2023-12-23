package com.canque.buddly

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.canque.buddly.databinding.FragmentHomeBinding
import com.canque.buddly.datastore.SharedPref
import com.canque.buddly.models.Expense

class HomeFragment : Fragment() {
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        initiateNav()

        val sharedPref = SharedPref(this.requireContext())

        binding.adjustBalanceButton.setOnClickListener() {
            sharedPref.balance = 5000.00
        }


        binding.textViewContent.setText("PHP " + sharedPref.balance.toString())

        return binding.root
    }
    private fun initiateNav() {
        binding.topAppBar.setNavigationOnClickListener {
            // Handle navigation icon press
            Toast.makeText(activity, "Feature to be added!", Toast.LENGTH_SHORT).show()
        }

        binding.topAppBar.setOnMenuItemClickListener { menuItem ->
            when (menuItem.itemId) {
                R.id.notification -> {
                    // Handle more item (inside overflow menu) press
                    Toast.makeText(activity, "Feature to be added!", Toast.LENGTH_SHORT).show()
                    true
                }
                else -> false
            }
        }
    }
}