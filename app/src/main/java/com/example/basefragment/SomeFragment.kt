package com.example.basefragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.basefragment.databinding.FragmentSomeBinding

class SomeFragment : BaseFragment<FragmentSomeBinding>() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        return super.onCreateView(inflater, container, savedInstanceState)
    }
}

fun printVlad(it: Any) {
    Log.i("vlad", "$it")
}