package com.example.myapplication

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

typealias clickHandler =  ((doctor : Doctor) -> Unit)
class CustomAdapter(
    private val dataSet: List<Doctor>,
    var clickHandler: clickHandler
) :
    RecyclerView.Adapter<CustomAdapter.ViewHolder>() {

    class ViewHolder(view: View, var clickHandler: clickHandler) :
        RecyclerView.ViewHolder(view) {
        val textView: TextView = view.findViewById(R.id.textView)
        var btnOnClick = view.findViewById<TextView>(R.id.btn_show)
//      val textViewAddress: TextView


        fun bind(doctor: Doctor, clickHandler: clickHandler){
            btnOnClick.setOnClickListener{
                clickHandler(doctor)
            }
        }
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.item, viewGroup, false)
        return ViewHolder(view, clickHandler)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        viewHolder.textView.text = dataSet[position].name
        viewHolder.bind(dataSet[position] , clickHandler)
//        viewHolder.textViewAddress.text = dataSet[position].adress
    }

    override fun getItemCount() = dataSet.size
}
