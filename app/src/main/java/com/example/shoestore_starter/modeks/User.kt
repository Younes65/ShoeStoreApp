package com.example.shoestore_starter.modeks

import android.os.Parcelable
import androidx.databinding.InverseMethod
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Shoe(var name: String, var size: Double, var company: String, var description: String,
                val images: List<String> = mutableListOf()) : Parcelable {

    }
