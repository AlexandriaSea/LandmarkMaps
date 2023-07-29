package com.example.wenjiezhou_shengwang_comp304sec002_lab05

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MainAdapter(private val context: Context, private val types: List<Type>) :
    RecyclerView.Adapter<MainAdapter.TypeViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TypeViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.recycler_main, parent, false)
        return TypeViewHolder(view)
    }

    override fun onBindViewHolder(holder: TypeViewHolder, position: Int) {
        val landmarkType = types[position]
        holder.type.text = landmarkType.name

        holder.itemView.setOnClickListener {
            val intent = Intent(context, LandmarkActivity::class.java)
            intent.putExtra("landmarkType", landmarkType.name)
            context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return types.size
    }

    class TypeViewHolder(TextView: View) : RecyclerView.ViewHolder(TextView) {
        val type: TextView = TextView.findViewById(R.id.textViewType)
    }
}