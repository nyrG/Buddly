package com.canque.buddly

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.canque.buddly.databinding.FragmentBudgetsBinding
import com.canque.buddly.databinding.FragmentExpensesBinding

class BudgetsFragment : Fragment() {
    private var _binding: FragmentBudgetsBinding? = null
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentBudgetsBinding.inflate(inflater, container, false)

        binding.topAppBar.setNavigationOnClickListener {
            // Handle navigation icon press
            Toast.makeText(activity, "Feature to be added!", Toast.LENGTH_SHORT).show()
        }

        binding.topAppBar.setOnMenuItemClickListener { menuItem ->
            when (menuItem.itemId) {
                R.id.calendar -> {
                    // Handle more item (inside overflow menu) press
                    Toast.makeText(activity, "Feature to be added!", Toast.LENGTH_SHORT).show()
                    true
                }
                else -> false
            }
        }

        return binding.root
    }
}