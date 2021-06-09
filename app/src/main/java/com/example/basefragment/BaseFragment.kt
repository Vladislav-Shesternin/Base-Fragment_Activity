package com.example.basefragment

import android.view.LayoutInflater
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.viewbinding.ViewBinding
import kotlin.reflect.KParameter
import kotlin.reflect.KProperty0
import kotlin.reflect.full.*

abstract class BaseFragment<VB : ViewBinding, VM : ViewModel> : Fragment() {

    inline fun <reified T : Any> type() = T::class.functions
        .filter {
            it.name == "inflate" && it.parameters.size == 1
        }.map {
            it.call(layoutInflater)
        }.first() as T

}

//    protected lateinit var binding: VB private set
//    protected abstract val initBinding: () -> VB
//
//    protected lateinit var viewModel: VM private set
//    protected abstract val initViewModel: () -> VM
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//
////        with(javaClass.genericSuperclass as ParameterizedType) {
////            val s = actualTypeArguments[1]::class as KClass<VM>
////        }
//
//        javaClass.genericSuperclass?.also { type ->
//            viewModel = ViewModelProvider(this, object : ViewModelProvider.Factory {
//                override fun <T : ViewModel?> create(modelClass: Class<T>): T {
//                    // TODO: 08.06.21
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

