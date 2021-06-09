package com.example.basefragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.viewbinding.ViewBinding
import com.example.basefragment.databinding.ActivityMainBinding
import com.example.basefragment.databinding.FragmentSomeBinding
import kotlin.reflect.full.declaredFunctions
import kotlin.reflect.full.declaredMemberExtensionProperties
import kotlin.reflect.full.declaredMemberProperties
import kotlin.reflect.full.functions

class SomeFragment : BaseFragment<FragmentSomeBinding, SomeViewModel>() {

//    override val initBinding = { FragmentSomeBinding.inflate(layoutInflater) }
//    override val initViewModel = { viewModels<SomeViewModel>().value }

    private lateinit var binding: FragmentSomeBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSomeBinding.inflate(inflater)
        printVlad("ooo Da: ${type<FragmentSomeBinding>().tvText.text}")
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
//        super.onViewCreated(view, savedInstanceState)
//        printVlad(binding.tvText.text)
//        printVlad(viewModel.text)
//    }

    }
}

fun printVlad(it: Any) {
    Log.i("vlad", "$it")
}