package com.example.shoestore_starter.modeks

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ListShoeViewModel : ViewModel() {

    val _shoe = MutableLiveData<ArrayList<Shoe>>()
    val shoe : LiveData<ArrayList<Shoe>>
    get () = _shoe

    var newName = " "
    var newSize = " "
    var newCompany = " "
    var newDescription = " "

      init {
         _shoe.value = ArrayList<Shoe>()
      }

    fun add(new:Shoe){
        (_shoe.value as ArrayList<Shoe>).add(new)
    }
    fun resetData (){
        newName = ""
        newSize = ""
        newCompany = ""
        newDescription = ""

    }

}