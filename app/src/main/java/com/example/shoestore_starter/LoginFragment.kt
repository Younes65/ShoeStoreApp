package com.example.shoestore_starter

import android.os.Bundle
import android.os.TokenWatcher
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.example.shoestore_starter.databinding.FragmentLoginBinding


class LoginFragment : Fragment() {
lateinit var binding : FragmentLoginBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding =DataBindingUtil.inflate(inflater,R.layout.fragment_login, container, false)
        binding.button.setOnClickListener {
            if (binding.EmailAddress.text.toString().isEmpty()){
                binding.EmailAddress.error = "Required"
            }
            else if (binding.Password.text.toString().isEmpty()) {
                binding.Password.error = "Required"

            }
            else {it.findNavController().navigate(R.id.action_loginFragment_to_welcomeFragment)
                Toast.makeText(activity, "Saved", Toast.LENGTH_SHORT).show();}
        }
        binding.button1.setOnClickListener {
            it.findNavController().navigate(R.id.action_loginFragment_to_welcomeFragment)
        }

        return binding.root
    }


}