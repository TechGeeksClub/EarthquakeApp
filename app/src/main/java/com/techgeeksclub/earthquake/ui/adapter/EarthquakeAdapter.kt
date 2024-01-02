package com.techgeeksclub.earthquake.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.techgeeksclub.earthquake.data.entity.Earthquake
import com.techgeeksclub.earthquake.data.entity.Result
import com.techgeeksclub.earthquake.databinding.EarthquakeItemBinding
import java.text.SimpleDateFormat
import java.util.Locale

class EarthquakeAdapter (var mContext: Context, var earthquakeList: Earthquake) : RecyclerView.Adapter<EarthquakeAdapter.HomePageItemHolder>(){

    inner class HomePageItemHolder(var item: EarthquakeItemBinding) : RecyclerView.ViewHolder(item.root)

    var result : List<Result> = listOf()

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

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomePageItemHolder {
        val binding = EarthquakeItemBinding.inflate(LayoutInflater.from(mContext), parent, false)
        return HomePageItemHolder(binding)
    }

    override fun getItemCount(): Int {
        return earthquakeList.result.size
    }

    override fun onBindViewHolder(holder: HomePageItemHolder, position: Int) {
        val earthquake = earthquakeList.result
        val binding = holder.item
        result = earthquake

        val formattedTime = formatToHourMinute(result[position].date.toString())

        binding.countryTV.text = result[position].title.toString()
        binding.intensityTV.text = result[position].mag.toString()
        binding.dateTimeTV.text = formattedTime



    }

    private fun formatToHourMinute(dateTime : String): String {
        val inputFormat = SimpleDateFormat("yyyy.MM.dd HH:mm:ss", Locale.getDefault())
        val outputFormat = SimpleDateFormat("HH:mm", Locale.getDefault())

        val date = inputFormat.parse(dateTime)
        return outputFormat.format(date)
    }



}