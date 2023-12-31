package com.techgeeksclub.earthquake.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.techgeeksclub.earthquake.data.entity.Result
import com.techgeeksclub.earthquake.R
import com.techgeeksclub.earthquake.data.entity.Earthquake

class EarthquakeRecyclerView(val earthquake : ArrayList<Earthquake>) : RecyclerView.Adapter<EarthquakeRecyclerView.EarthquakeViewHolder>() {
    var result : ArrayList<Result> = arrayListOf()
    var howManyMinutes : ArrayList<String> = arrayListOf()
    var intensity : ArrayList<Double> = arrayListOf()
    var country : ArrayList<String> = arrayListOf()

    init {
        /*earthquake.forEach {
            result = it.result
            it.result.forEach {
                val dateNow = LocalDateTime.now()
                val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")
                val formatted = dateNow.format(formatter)


                //howManyMinutes = it.date

            }
        }*/
    }

    class EarthquakeViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        var countryFlagIV : ImageView = itemView.findViewById(R.id.countryFlagIV)
        var countryTV : TextView = itemView.findViewById(R.id.countryTV)
        var intensityTV : TextView = itemView.findViewById(R.id.intensityTV)
        var howManyMinutesTV : TextView = itemView.findViewById(R.id.HowManyMinutesTV)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EarthquakeViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.earthquake_item,parent,false)
        return EarthquakeViewHolder(view)
    }

    override fun getItemCount(): Int {
        return 20
    }

    override fun onBindViewHolder(holder: EarthquakeViewHolder, position: Int) {
        //holder.howManyMinutesTV.text =
    }
}