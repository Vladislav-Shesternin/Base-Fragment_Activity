package com.example.basefragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding
import java.lang.reflect.ParameterizedType

abstract class BaseFragment<VB : ViewBinding> : Fragment() {

    protected lateinit var binding: VB private set

    private val type = (javaClass.genericSuperclass as ParameterizedType)
    private val classVB = type.actualTypeArguments[0] as Class<VB>

    private val inflateMethod = classVB.getMethod(
        "inflate",
        LayoutInflater::class.java,
        ViewGroup::class.java,
        Boolean::class.java
    )

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = inflateMethod.invoke(null, inflater, container, false) as VB

        return binding.root
    }

}


////        with(javaClass.genericSuperclass as ParameterizedType) {
////            val s = actualTypeArguments[1]::class as KClass<VM>
////        }
//
//        javaClass.genericSuperclass?.also { type ->
//            viewModel = ViewModelProvider(this, object : ViewModelProvider.Factory {
//                override fun <T : ViewModel?> create(modelClass: Class<T>): T {
//
//                    return T
//                }
//            }).get((type as ParameterizedType).actualTypeArguments[1]::class.java as Class<VM>)
//        }
//
//    }
//
//    private fun createBinding(inflater: LayoutInflater, parent: ViewGroup?): VB {
//        val bindingClass =
//            (javaClass.genericSuperclass as ParameterizedType).actualTypeArguments[0].javaClass
//        val method = bindingClass.getMethod(
//            "inflate",
//            LayoutInflater::class.java,
//            ViewGroup::class.java,
//            Boolean::class.java
//        )
//        return method.invoke(null, inflater, parent, false) as VB
//    }

