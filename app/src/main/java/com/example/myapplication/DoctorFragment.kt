package com.example.myapplication

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.myapplication.databinding.FragmentDoctorBinding

class DoctorFragment : Fragment() {

    lateinit var binding2: FragmentDoctorBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding2 = FragmentDoctorBinding.inflate(inflater, container, false)
        val doctor = activity?.intent?.getParcelableExtra<Doctor>("doctor")
        Log.d("ACTIVITY2", "doctor" + doctor?.name)
        Toast.makeText(activity,doctor?.name.toString(), Toast.LENGTH_SHORT ).show()

        binding2.textView2.text = doctor?.name.toString()
        binding2.textView5.text = doctor?.phoneNumber.toString()
        binding2.textView6.text = doctor?.adress.toString()



        Toast.makeText(activity, "clicked", Toast.LENGTH_SHORT).show()
        return binding2.root
       }


}