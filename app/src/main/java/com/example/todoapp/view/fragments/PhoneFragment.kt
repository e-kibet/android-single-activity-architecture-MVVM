package com.example.todoapp.view.fragments
import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.navigation.findNavController
import com.example.todoapp.R
import com.example.todoapp.databinding.FragmentPhoneBinding
import com.example.todoapp.network.ApiServices
import com.example.todoapp.network.Resource
import com.example.todoapp.repository.PhoneRepository
import com.example.todoapp.viewmodel.PhoneViewModel

class PhoneFragment : BaseFragment<PhoneViewModel, FragmentPhoneBinding, PhoneRepository>() {
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel.checkPhoneResponse.observe(viewLifecycleOwner, Observer {
            when(it){
                is Resource.Success->{
                    Toast.makeText(requireContext(), it.toString(), Toast.LENGTH_LONG).show()
                }
                is Resource.Failure->{
                    Toast.makeText(requireContext(), "Login failure", Toast.LENGTH_SHORT).show()
                }
            }
        })
        binding.continuebutton.setOnClickListener {
            binding.continuebutton.showLoading()
            val msisdn = binding.msisdnEditText.text.toString().trim()
            if(msisdn.isBlank()){
               // binding.wp7progressBar.hideProgressBar()
                   binding.continuebutton.hideLoading()
                Toast.makeText(requireContext(), "Please enter the phone number", Toast.LENGTH_SHORT).show()
            }else {
                viewModel.checkPhone(msisdn)
            }
        }
        binding.backIconButton.setOnClickListener {
            it.findNavController().navigate(R.id.fragment_welcome)
        }
    }
    override fun getViewModel() = PhoneViewModel::class.java

    override fun getFragmentBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ) = FragmentPhoneBinding.inflate(inflater, container, false)

    override fun getFramentRepository() = PhoneRepository(remoteDataSource.buildApi(ApiServices::class.java))

}