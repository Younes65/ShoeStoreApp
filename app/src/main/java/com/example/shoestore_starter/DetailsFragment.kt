package com.example.shoestore_starter

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import com.example.shoestore_starter.databinding.FragmentDetailsBinding
import com.example.shoestore_starter.databinding.FragmentListBinding
import com.example.shoestore_starter.databinding.FragmentLoginBinding
import com.example.shoestore_starter.modeks.ListShoeViewModel
import com.example.shoestore_starter.modeks.Shoe


class DetailsFragment : Fragment() {
 private val viewModel: ListShoeViewModel by activityViewModels ()
    lateinit var binding: FragmentDetailsBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDetailsBinding.inflate(inflater, container, false)
        //  viewModel = ViewModelProvider(this)[ListShoeViewModel::class.java]
        viewModel.resetData()
        binding.myViewModel = viewModel

        viewModel.shoe.observe(viewLifecycleOwner, Observer {

        binding.saveButton.setOnClickListener {

            if (binding.editText1.text.toString().isEmpty()){
                binding.editText1.error = "Required"
            }
            else if (binding.editText2.text.toString().isEmpty()) {
                binding.editText2.error = "Required"

            }
            else if (binding.editText3.text.toString().isEmpty()) {
                binding.editText3.error = "Required"}
            else if (binding.editText4.text.toString().isEmpty()) {
                binding.editText4.error = "Required"}
            else {
                viewModel.add(Shoe(viewModel.newName,viewModel.newSize.toDouble(),viewModel.newCompany,viewModel.newDescription))
                it.findNavController().navigate(R.id.action_detailsFragment_to_listFragment)
                Toast.makeText(activity, "Added successfully :)", Toast.LENGTH_SHORT).show()
            }
        }
        })
        binding.cancelButtom.setOnClickListener {
            it.findNavController().navigate(R.id.action_detailsFragment_to_listFragment)
        }

        return binding.root
    }


}