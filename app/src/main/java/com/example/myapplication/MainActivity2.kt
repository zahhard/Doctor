package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.databinding.ActivityMain2Binding

class MainActivity2 : AppCompatActivity() {

    lateinit var binding: ActivityMain2Binding

    lateinit var buttonID: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMain2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        init()

        var adapter = CustomAdapter(Hospital.doctorList) { doctor -> goToActivity1(doctor.id) }
        binding.recyclerView.adapter = adapter

    }

    private fun init() {
        Hospital.loadTestDoctor()

//        binding.button.text = Hospital.doctorList[0].name
//        binding.button2.text = Hospital.doctorList[1].name
//        binding.button3.text = Hospital.doctorList[2].name
//
//        binding.button.setOnClickListener { goToActivity1("button") }
//        binding.button2.setOnClickListener { goToActivity1("button2") }
//        binding.button3.setOnClickListener { goToActivity1("button3") }
    }

    private fun goToActivity1(s: String) {

        val intent = Intent(this, MainActivity::class.java)

        if (s == "button")
            intent.putExtra("doctor", Hospital.doctorList[0])

        if (s == "button2")
            intent.putExtra("doctor", Hospital.doctorList[1])

        if (s == "button3")
            intent.putExtra("doctor", Hospital.doctorList[2])

        startActivity(intent)

    }private fun goToActivity1(s: Int) {

        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }

}