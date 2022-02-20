package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.myapplication.databinding.ActivityMain2Binding
import com.example.myapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding2 : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding2 = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding2.root)


        val doctor = intent.getParcelableExtra<Doctor>("doctor")
        Log.d("ACTIVITY2", "doctor" + doctor?.name)
        Toast.makeText(this,doctor?.name.toString(),Toast.LENGTH_SHORT ).show()

        title = doctor?.name.toString()

    }
}