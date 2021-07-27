package com.example.todoapp.view.fragments
import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import com.example.todoapp.databinding.FragmentRegisterBinding
import com.example.todoapp.network.ApiServices
import com.example.todoapp.network.Resource
import com.example.todoapp.repository.RegisterRepository
import com.example.todoapp.viewmodel.RegisterViewModel

class RegisterFragment : BaseFragment<RegisterViewModel, FragmentRegisterBinding, RegisterRepository> (){
    override fun onActivityCreated(savedInstanceState: Bundle?
    ) {
        super.onActivityCreated(savedInstanceState)
        viewModel.registerResponse.observe(viewLifecycleOwner, {
            when(it){
                is Resource.Success -> {
                    Toast.makeText(requireContext(), it.toString(), Toast.LENGTH_SHORT).show()
                }
                is Resource.Failure -> {
                    Toast.makeText(requireContext(), it.toString(), Toast.LENGTH_SHORT).show()
                }
            }

        })

        binding.registerButton.setOnClickListener {
            binding.registerButton.showLoading()
            val first_name = binding.firstNameEditText.toString().trim()
            val last_name = binding.lastNameEditText.toString().trim()
            val msisdn = binding.msisdnEditText.toString().trim()
            val password = binding.passwordEditText.toString().trim()

            if(first_name.isBlank() || last_name.isBlank() || msisdn.isBlank() || password.isBlank()){
                binding.registerButton.hideLoading()
            }else{
                viewModel.makeRegisterRequest(first_name, last_name, msisdn, "1", password)
            }
        }
    }

    override fun getViewModel() = RegisterViewModel::class.java

    override fun getFragmentBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ) = FragmentRegisterBinding.inflate(inflater, container, false)

    override fun getFramentRepository() = RegisterRepository(remoteDataSource.buildApi(ApiServices::class.java))

}