package com.example.basefragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.basefragment.databinding.FragmentSomeBinding

class SomeFragment : BaseFragment<FragmentSomeBinding>() {

    private lateinit var bindings: FragmentSomeBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        bindings = FragmentSomeBinding.inflate(inflater)

        return bindings.root
    }
}

fun printVlad(it: Any) {
    Log.i("vlad", "$it")
}