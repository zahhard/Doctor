package com.example.myapplication

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class Adapter
class CustomAdapter(private val dataSet: List<Doctor>) :
    RecyclerView.Adapter<CustomAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val textView: TextView
        val textViewNum: TextView
        val textViewAddress: TextView

        init {
            textView = view.findViewById(R.id.textView)
            textViewNum = view.findViewById(R.id.tv_num)
            textViewAddress = view.findViewById(R.id.tv_city)
        }
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.item, viewGroup, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        viewHolder.textView.text = dataSet[position].name
        viewHolder.textViewNum.text = dataSet[position].phoneNumber.toString()
        viewHolder.textViewAddress.text = dataSet[position].adress
    }

    override fun getItemCount() = dataSet.size
}
