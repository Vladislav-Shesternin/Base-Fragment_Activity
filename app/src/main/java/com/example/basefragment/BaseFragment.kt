package com.example.basefragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding
import java.lang.reflect.ParameterizedType

abstract class BaseFragment<VB : ViewBinding> : Fragment() {

    lateinit var binding: VB

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val type = (javaClass.genericSuperclass as ParameterizedType).actualTypeArguments[0]

        val clazz = type as Class<VB>

        printVlad("$clazz")


        clazz.methods.forEach {
            printVlad(
                """
                ${it.name}
            """.trimIndent()
            )
        }

        val s = clazz.getMethod(
            "inflate",
            LayoutInflater::class.java,
            ViewGroup::class.java,
            Boolean::class.java
        )
//
        printVlad("method: $s")
//
//        val f = s.invoke(null, )
    }

}

fun getViewBinding() {}


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

