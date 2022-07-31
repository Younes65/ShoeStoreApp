package com.example.shoestore_starter

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import com.example.shoestore_starter.databinding.FragmentTipsBinding
import com.example.shoestore_starter.modeks.MyData


class TipsFragment : Fragment() {
    lateinit var binding : FragmentTipsBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentTipsBinding.inflate(inflater, container, false)
        val tip = MyData("Welcome to our app before we start, you should know some tips about shoe store,we show some products to different brands of shoes,and also you can share yours on this up u can press on the button and fill details about your shoes,that is it, enjoy your view.")
        binding.myData= tip

        binding.button3.setOnClickListener {
            it.findNavController().navigate(R.id.action_tipsFragment_to_listFragment)
        }
        return binding.root
    }

}