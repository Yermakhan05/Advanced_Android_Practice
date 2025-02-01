package com.example.bonusapp.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.bonusapp.R
import com.example.bonusapp.databinding.FragmentHomeBinding
import com.example.bonusapp.ui.dashboard.DashboardFragment

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private var counter = 0
    private var randomNumber: Int = 0
    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val homeViewModel =
            ViewModelProvider(this).get(HomeViewModel::class.java)

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root

        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentHomeBinding.bind(view)

        if (randomNumber == 0) {
            binding.randomNumberText.text = "Generate Number"
        } else {
            binding.randomNumberText.text = randomNumber.toString()
        }

        binding.generateButton.setOnClickListener {
            randomNumber = (1..100).random()
            binding.randomNumberText.text = randomNumber.toString()
            val bundle = Bundle().apply {
                putInt("randomNumber", randomNumber)
            }
            val secondFragment = DashboardFragment().apply {
                arguments = bundle
            }
        }

//        binding.counterTextView.text = counter.toString()
//        binding.incrementButton.setOnClickListener {
//            counter++
//            binding.counterTextView.text = counter.toString()
//        }
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}