package com.udacity.shoestore.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.udacity.shoestore.models.Shoe

class ShoeViewModel : ViewModel(){
    private var _shoeMutableLiveData : MutableLiveData<ArrayList<Shoe>> = MutableLiveData()
    val shoeLiveData : LiveData<ArrayList<Shoe>> get() = _shoeMutableLiveData

    private val desc = "Running Shoe is a shoe made by Adidas for running and sports"


    fun addShoes(){
        val arr : ArrayList<Shoe> = ArrayList()
        arr.add(Shoe("Golf Shoe" , 40.0 ,"Nike" , desc ))
        arr.add(Shoe("Running Shoe" , 43.0 ,"Adidas" , desc ))
        arr.add(Shoe("High Tops" , 42.0 ,"Nike" , desc ))
        arr.add(Shoe("ice-skates" , 39.0 ,"Air Jordan" , desc ))
        arr.add(Shoe("old Skool" , 41.0 ,"Nike" , desc ))
        arr.add(Shoe("Hiking boots" , 42.0 ,"Adidas" , desc ))

        _shoeMutableLiveData.value = arr
    }

     fun addShoe(shoe : Shoe) {
        try{
            _shoeMutableLiveData.value?.add(shoe)
        }
        catch (e:Exception){
            e.printStackTrace()
        }
    }

}