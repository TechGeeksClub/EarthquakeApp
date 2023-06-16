package com.techgeeksclub.earthquake.ui.home

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.techgeeksclub.earthquake.R

class EarthquakeRecyclerView : RecyclerView.Adapter<EarthquakeRecyclerView.EarthquakeViewHolder>() {

    class EarthquakeViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        var countryFlagIV : ImageView = itemView.findViewById(R.id.countryFlagIV)
        var countryTV : ImageView = itemView.findViewById(R.id.countryTV)
        var intensityTV : ImageView = itemView.findViewById(R.id.intensityTV)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EarthquakeViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.earthquake_row,parent,false)
        return EarthquakeViewHolder(view)
    }

    override fun getItemCount(): Int {
        return 1
    }

    override fun onBindViewHolder(holder: EarthquakeViewHolder, position: Int) {

    }
}