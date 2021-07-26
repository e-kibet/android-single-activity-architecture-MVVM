package com.example.todoapp.view.fragments
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.example.todoapp.R
import com.example.todoapp.databinding.FragmentWelcomeBinding
import com.example.todoapp.view.listeners.PhoneHandler

class WelcomeFragment : Fragment(), PhoneHandler {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_welcome, container, false)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val binding = FragmentWelcomeBinding.bind(view) 
        binding.nextButton.setOnClickListener {
            onPhoneClicked(it)
        }
    }

    override fun onPhoneClicked(view: View) {
        view.findNavController().navigate(R.id.fragment_phone)
    }

}

//https://github.com/fahadnasrullah109/Android-MVVM-with-Retrofit
//https://github.com/unaisulhadi/MVVM-Retrofit-Coroutine
//https://github.com/unaisulhadi/MVVM-Retrofit-Coroutine
//https://github.com/chandragithub2014/ParentFragmentSample
//https://github.com/chandragithub2014/MVVMAndroid