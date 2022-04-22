package com.example.myapplication

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Adapter
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView

typealias clickHandler = ((doctor: Doctor) -> Unit)

class CustomAdapter(
        var clickHandler: clickHandler
) :
   // RecyclerView.Adapter<CustomAdapter.ViewHolder>()
    ListAdapter<Doctor, CustomAdapter.ViewHolder>(QuestionDiffCallback)
{

    class ViewHolder(view: View) :
        RecyclerView.ViewHolder(view) {
        val textView: TextView = view.findViewById(R.id.textView)
        var btnOnClick = view.findViewById<TextView>(R.id.btn_show)


        fun bind(doctor: Doctor, clickHandler: clickHandler) {
            btnOnClick.setOnClickListener {
                clickHandler(doctor)
            }
        }
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.item, viewGroup, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        viewHolder.textView.text = getItem(position).name
        viewHolder.bind(getItem(position), clickHandler)
    }

    object QuestionDiffCallback : DiffUtil.ItemCallback<Doctor>() {
        override fun areItemsTheSame(oldItem: Doctor, newItem: Doctor): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: Doctor, newItem: Doctor): Boolean {
            return oldItem == newItem
        }
    }
}
