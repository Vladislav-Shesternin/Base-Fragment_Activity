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
import kotlin.reflect.KClass
import kotlin.reflect.full.declaredFunctions
import kotlin.reflect.full.declaredMemberExtensionProperties
import kotlin.reflect.full.declaredMemberProperties
import kotlin.reflect.full.functions

class SomeFragment : BaseFragment<FragmentSomeBinding>(
    FragmentSomeBinding::class
) {

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