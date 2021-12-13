package com.example.proyectosprint

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class Adapter (private val datos: ArrayList<Task1>, private val clickListener: (Task1) -> Unit):
    RecyclerView.Adapter<Adapter.TaskViewHolder>() {

    class TaskViewHolder (val layout: View): RecyclerView.ViewHolder(layout)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskViewHolder {
        val layout = LayoutInflater.from(parent.context)
            .inflate(R.layout.list_items, parent, false)
        return TaskViewHolder(layout)
    }

    override fun onBindViewHolder(holder: TaskViewHolder, position: Int) {
        val task = datos [position]
        val textViewDetalle: TextView = holder.layout.findViewById(R.id.textDetails)
        val textViewCodigo: TextView = holder.layout.findViewById(R.id.textCode)
        textViewDetalle.text = task.cortina
        textViewCodigo.text= task.id.toString()
        holder.layout.setOnClickListener { clickListener (task) }
    }

    override fun getItemCount(): Int {
        return datos.size
    }

}