package com.example.basefragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.viewbinding.ViewBinding
import java.lang.reflect.ParameterizedType
import kotlin.reflect.KClass

abstract class BaseFragment<VB : ViewBinding, VM : ViewModel> : Fragment() {

    protected lateinit var binding: VB private set
    protected lateinit var viewModel: VM private set

    private val type = (javaClass.genericSuperclass as ParameterizedType)
    private val classVB = type.actualTypeArguments[0] as Class<VB>
    private val classVM = type.actualTypeArguments[1] as Class<VM>

    private val inflateMethod = classVB.getMethod(
        "inflate",
        LayoutInflater::class.java,
        ViewGroup::class.java,
        Boolean::class.java
    )

    private val viewModelProvider by lazy {
        ViewModelProvider(this, object : ViewModelProvider.Factory {
            override fun <T : ViewModel> create(modelClass: Class<T>): T {
                return modelClass.getConstructor().newInstance()
            }
        })
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = inflateMethod.invoke(null, inflater, container, false) as VB
        viewModel = viewModelProvider.get(classVM)

        return binding.root
    }
}