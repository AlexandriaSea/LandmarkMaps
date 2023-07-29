package com.example.wenjiezhou_shengwang_comp304sec002_lab05

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class LandmarkAdapter(private val context: Context, private val landmarks: List<Landmark>) :
    RecyclerView.Adapter<LandmarkAdapter.LandmarkViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LandmarkViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.recycler_landmark, parent, false)
        return LandmarkViewHolder(view)
    }

    override fun onBindViewHolder(holder: LandmarkViewHolder, position: Int) {
        val landmark = landmarks[position]
        holder.name.text = landmark.name
        holder.address.text = landmark.address

        holder.itemView.setOnClickListener {
            val intent = Intent(context, MapsActivity::class.java)
            intent.putExtra("name", landmark.name)
            intent.putExtra("latitude", landmark.latitude)
            intent.putExtra("longitude", landmark.longitude)
            context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return landmarks.size
    }

    class LandmarkViewHolder(TextView: View) : RecyclerView.ViewHolder(TextView) {
        val name: TextView = TextView.findViewById(R.id.textViewName)
        val address: TextView = TextView.findViewById(R.id.textViewAddress)
    }
}
