package com.example.myapplication

import android.os.Parcelable
import androidx.lifecycle.ViewModel
import kotlinx.android.parcel.Parcelize

object Hospital {
    var doctorList = ArrayList<Doctor>()

    fun loadTestDoctor(){
        doctorList.clear()
        val d1 = Doctor("سارا بهرامی", 1, 332210, "تهران")
        val d2 = Doctor("کوثر سپهسالار", 2, 323565, "تبریز")
        val d3 = Doctor("آراز کبریان", 3, 355598, "بوشهر")
        doctorList.add(d1)
        doctorList.add(d2)
        doctorList.add(d3)
    }
}

@Parcelize
data class Doctor(var name: String, var id: Int, var phoneNumber: Long, var adress: String): Parcelable

class MainViewModel : ViewModel() {
    fun name(doctor: Doctor): String{
        return (doctor.name)
    }

    fun address(doctor: Doctor): String{
        return (doctor.adress)
    }

    fun phone(doctor: Doctor): String{
        return (doctor.phoneNumber.toString())
    }
}


