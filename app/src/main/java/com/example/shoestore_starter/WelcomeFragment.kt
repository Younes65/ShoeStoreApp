package com.example.shoestore_starter

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.example.shoestore_starter.databinding.FragmentWelcomeBinding


class WelcomeFragment : Fragment() {

lateinit var binding: FragmentWelcomeBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

       binding = FragmentWelcomeBinding.inflate(inflater, container, false)
        binding.button2.setOnClickListener {
            it.findNavController().navigate(R.id.action_welcomeFragment_to_tipsFragment)
        }


        return binding.root
    }

}