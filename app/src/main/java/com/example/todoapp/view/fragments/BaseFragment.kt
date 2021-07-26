package com.example.todoapp.view.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.viewbinding.ViewBinding
import com.example.todoapp.network.RestClient
import com.example.todoapp.repository.BaseRepository
import com.example.todoapp.viewmodel.ViewModelFactory

abstract class BaseFragment <VM: ViewModel, B: ViewBinding, R: BaseRepository>: Fragment(){
    protected lateinit var binding: B
    lateinit var viewModel:VM


    protected val remoteDataSource   = RestClient()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding  = getFragmentBinding(inflater, container)
        val factory = ViewModelFactory(getFramentRepository());
        viewModel = ViewModelProvider(this, factory).get(getViewModel())
        return binding.root
    }

    abstract fun getViewModel():Class<VM>

    abstract fun getFragmentBinding(inflater: LayoutInflater, container: ViewGroup?): B

    abstract fun getFramentRepository():R
}