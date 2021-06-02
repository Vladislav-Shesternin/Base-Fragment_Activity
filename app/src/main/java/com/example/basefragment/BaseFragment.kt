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
import kotlin.jvm.internal.Reflection
import kotlin.reflect.KClass

abstract class BaseFragment<VB : ViewBinding, VM : ViewModel> : Fragment() {

    protected lateinit var binding: VB private set
    protected abstract val initBinding: () -> VB

    protected lateinit var viewModel: VM private set
    protected abstract val initViewModel: () -> VM

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

//        with(javaClass.genericSuperclass as ParameterizedType) {
//            val s = actualTypeArguments[1]::class as KClass<VM>
//        }
        
        javaClass.genericSuperclass?.also { type ->
            viewModel = ViewModelProvider(this, object : ViewModelProvider.Factory {
                override fun <T : ViewModel?> create(modelClass: Class<T>): T {

                }
            }).get((type as ParameterizedType).actualTypeArguments[1]::class.java as Class<VM>)
        }

    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = createBinding(inflater, container)
        return binding.root
    }

    private fun createBinding(inflater: LayoutInflater, parent: ViewGroup?): VB {
        val bindingClass =
            (javaClass.genericSuperclass as ParameterizedType).actualTypeArguments[0].javaClass
        val method = bindingClass.getMethod(
            "inflate",
            LayoutInflater::class.java,
            ViewGroup::class.java,
            Boolean::class.java
        )
        return method.invoke(null, inflater, parent, false) as VB
    }

    private fun createViewModel


}