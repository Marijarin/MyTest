package ru.marijarin.mytest.mytest.activity

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import ru.marijarin.mytest.databinding.FragmentTestBinding
import ru.marijarin.mytest.mytest.viewmodel.TestViewModel

class TestFragment : Fragment() {
    private val testViewModel: TestViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = FragmentTestBinding.inflate(
            inflater,
            container,
            false
        )
        return binding.root
    }

}