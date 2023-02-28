package ru.marijarin.mytest.mytest.activity

import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import ru.marijarin.mytest.mytest.viewmodel.ResultViewModel

class ResultFragment: Fragment() {
    private val resultViewModel: ResultViewModel by activityViewModels()
}