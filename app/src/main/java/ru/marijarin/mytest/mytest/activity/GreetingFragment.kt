package ru.marijarin.mytest.mytest.activity

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import ru.marijarin.mytest.R
import ru.marijarin.mytest.databinding.FragmentGreetingBinding

class GreetingFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = FragmentGreetingBinding.inflate(inflater, container, false)
        binding.start.setOnClickListener {
            findNavController().navigate(R.id.action_greetingFragment_to_testFragment)
        }
        return binding.root
    }
}