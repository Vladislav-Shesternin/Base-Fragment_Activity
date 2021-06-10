package com.example.basefragment

import android.os.Bundle
import android.view.LayoutInflater
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.viewbinding.ViewBinding
import java.lang.reflect.ParameterizedType
import java.lang.reflect.Type
import kotlin.reflect.KClass
import kotlin.reflect.KParameter
import kotlin.reflect.KProperty0
import kotlin.reflect.full.*
import kotlin.reflect.typeOf

abstract class BaseFragment<VB : ViewBinding>(
    private val typeVB: KClass<out VB>
) : Fragment() {

    lateinit var binding: VB

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        printVlad("type - ${typeVB}")
        printVlad("binding - ${typess()}")
    }

    private fun getViewBinding() = typeVB.functions
        .filter {
            it.name == "inflate" && it.parameters.size == 1
        }.map {
            it.call(layoutInflater)
        }.first() as VB

    private fun typess() = (javaClass.genericSuperclass as ParameterizedType).actualTypeArguments[0]

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
//    override fun onCreateView(
//        inflater: LayoutInflater,
//        container: ViewGroup?,
//        savedInstanceState: Bundle?
//    ): View {
//        binding = createBinding(inflater, container)
//        return binding.root
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

