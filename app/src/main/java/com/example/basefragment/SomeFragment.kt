package com.example.basefragment

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.viewModels
import androidx.viewbinding.ViewBinding
import com.example.basefragment.databinding.FragmentSomeBinding

class SomeFragment : BaseFragment<FragmentSomeBinding, SomeViewModel>() {

    override val initBinding = { FragmentSomeBinding.inflate(layoutInflater) }
    override val initViewModel = { viewModels<SomeViewModel>().value }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        printVlad(binding.tvText.text)
        printVlad(viewModel.text)
    }

}

fun printVlad(it: Any) {
    Log.i("vlad", "$it")
}