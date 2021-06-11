package com.example.basefragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.basefragment.databinding.FragmentSomeBinding

class SomeFragment : BaseFragment<FragmentSomeBinding, SomeViewModel>() {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        printVlad("${viewModel.text}")
        binding
    }
}

fun printVlad(it: Any) {
    Log.i("vlad", "$it")
}