package com.example.bonusapp.ui.dashboard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.bonusapp.databinding.FragmentDashboardBinding

class DashboardFragment : Fragment() {

    private var _binding: FragmentDashboardBinding? = null

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val dashboardViewModel =
            ViewModelProvider(this).get(DashboardViewModel::class.java)

        _binding = FragmentDashboardBinding.inflate(inflater, container, false)
        val root: View = binding.root

        var randomNumber = 0
        randomNumber = (1..100).random()
        binding.mathTaskText.text = "Solve: $randomNumber + 5 = ?"

        binding.startTaskButton.setOnClickListener {
            val userAnswer = binding.inputAnswer.text.toString().toIntOrNull()
            val correctAnswer = (randomNumber + 5)
            if (userAnswer == correctAnswer) {
                Toast.makeText(context, "Correct! Congratulations!", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(context, "Wrong answer, try again.", Toast.LENGTH_SHORT).show()
            }
        }
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}