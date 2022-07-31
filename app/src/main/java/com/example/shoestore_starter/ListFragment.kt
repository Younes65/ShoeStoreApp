package com.example.shoestore_starter

import android.os.Bundle
import android.view.*
import android.widget.ArrayAdapter
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.NavigationUI
import com.example.shoestore_starter.databinding.FragmentListBinding
import com.example.shoestore_starter.modeks.ListShoeViewModel
import com.example.shoestore_starter.modeks.Shoe

class ListFragment : Fragment() {

     private val viewModel : ListShoeViewModel by activityViewModels()

    lateinit var binding: FragmentListBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentListBinding.inflate(inflater, container, false)
        //viewModel = ViewModelProvider(this)[ListShoeViewModel::class.java]

        viewModel.shoe.observe(viewLifecycleOwner, Observer {
          //  binding.container.removeAllViews()
            for (i in it) {
               addShoe(i.name,i.size,i.company,i.description)
            }
        })

        setHasOptionsMenu(true)

        binding.floatbutton.setOnClickListener{
            it.findNavController().navigate(R.id.action_listFragment_to_detailsFragment)
        }
        return binding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.menu_item,menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.logout -> findNavController().navigate(R.id.action_listFragment_to_loginFragment)
        }
        return super.onOptionsItemSelected(item)
    }
    fun addShoe(shoeName: String,shoeSize : Double , shoeCompany:String,shoeDescription:String) {
        var view = layoutInflater.inflate(R.layout.item_list, null)
        with(view){
            findViewById<TextView>(R.id.txtView).text = shoeName
            findViewById<TextView>(R.id.txtView1).text = shoeSize.toString()
            findViewById<TextView>(R.id.txtView2).text = shoeCompany
            findViewById<TextView>(R.id.txtView3).text = shoeDescription }
        binding.container.addView(view)

    }
    }

