package com.techgeeksclub.earthquake.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.techgeeksclub.earthquake.data.entity.Earthquake
import com.techgeeksclub.earthquake.data.entity.Result
import com.techgeeksclub.earthquake.databinding.EarthquakeItemBinding
import java.lang.Math.abs
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

class EarthquakeAdapter (var mContext: Context, var earthquakeList: Earthquake, private val listener: OnItemClickListener) : RecyclerView.Adapter<EarthquakeAdapter.HomePageItemHolder>(){

    inner class HomePageItemHolder(var item: EarthquakeItemBinding) : RecyclerView.ViewHolder(item.root)

    var result : List<Result> = listOf()


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
        val minutesPassed = calculateMinutesPassed(result[position].date.toString())

        binding.countryTV.text = result[position].title.toString()
        binding.intensityTV.text = result[position].mag.toString()
        binding.dateTimeTV.text = formattedTime
        binding.minutesPassedTV.text = minutesPassed

        holder.itemView.setOnClickListener {
            listener.onItemClick(result[position])
        }



    }

    private fun formatToHourMinute(dateTime : String): String {
        val inputFormat = SimpleDateFormat("yyyy.MM.dd HH:mm:ss", Locale.getDefault())
        val outputFormat = SimpleDateFormat("HH:mm", Locale.getDefault())

        val date = inputFormat.parse(dateTime)
        return outputFormat.format(date)
    }

    private fun calculateMinutesPassed(dateTime: String): String{
        val inputFormat = SimpleDateFormat("yyyy.MM.dd HH:mm:ss", Locale.getDefault())
        val currentDate = Date()
        val startDate = inputFormat.parse(dateTime)
        val difference = currentDate.time - startDate.time

        val differenceInMinutes = Math.abs(difference / (60 * 1000))

        return  formatTimeDifference(differenceInMinutes)// toplam milisaniye farkını dakika olarak hesaplar
    }

    private fun formatTimeDifference(minutes : Long) : String {

        val hours = minutes / 60
        val remainingMinutes = minutes % 60

        val formattedString = StringBuilder()

        if (hours > 0) {
            formattedString.append("$hours h")
        }
        if (remainingMinutes > 0) {
            formattedString.append(" $remainingMinutes m")
        }

        return formattedString.toString().trim()

    }

    interface OnItemClickListener {
        fun onItemClick(item: Result)
    }


}