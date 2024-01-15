package com.techgeeksclub.earthquake.ui.fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.techgeeksclub.earthquake.data.entity.Result
import com.techgeeksclub.earthquake.databinding.FragmentHomeBinding
import com.techgeeksclub.earthquake.ui.adapter.EarthquakeAdapter
import com.techgeeksclub.earthquake.ui.viewmodel.HomeViewModel
import dagger.hilt.android.AndroidEntryPoint
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale


@AndroidEntryPoint
class HomeFragment : Fragment(), OnMapReadyCallback {

    private lateinit var viewModel: HomeViewModel
    private lateinit var binding: FragmentHomeBinding
    private var mMap: GoogleMap? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val tempViewModel : HomeViewModel by viewModels()
        viewModel = tempViewModel
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(inflater)

        val layoutManager = LinearLayoutManager(context)
        binding.recyclerView.layoutManager = layoutManager

        viewModel.earthquakes.observe(viewLifecycleOwner){
            val adapter = EarthquakeAdapter(requireContext(),it,object :
                EarthquakeAdapter.OnItemClickListener {
                override fun onItemClick(item: Result) {
                    // Details of the clicked item are displayed here.
                   handleItemClickDetails(item)
                }
                })
            binding.recyclerView.adapter = adapter
            it.result.forEach {
                Log.d("Deneme",it.title.toString())
            }

        }

        binding.backButton.setOnClickListener {
            binding.earthquakeDetailsLayout.visibility = View.GONE
            binding.recyclerView.visibility = View.VISIBLE
        }

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        val mapFragment = childFragmentManager.findFragmentById(com.techgeeksclub.earthquake.R.id.map) as SupportMapFragment?
        mapFragment?.getMapAsync(this)

    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(HomeViewModel::class.java)
    }

    override fun onMapReady(p0: GoogleMap) {
        mMap = p0

        viewModel.earthquakes.observe(viewLifecycleOwner) { earthquakesList ->
            mMap?.clear()

            val turkeyLatLng = LatLng(39.9334, 32.8597)
            mMap?.moveCamera(CameraUpdateFactory.newLatLngZoom(turkeyLatLng, 4f))

            //Adding pins for each earthquake
            earthquakesList.result.forEach { earthquake ->
                val coordinates = earthquake.geojson?.coordinates
                val latitude = coordinates?.get(1)
                val longitude = coordinates?.get(0)

                val location = LatLng(latitude!!, longitude!!)
                mMap?.addMarker(
                    MarkerOptions()
                        .position(location)
                        .title(earthquake.title)
                )
            }
        }
    }

    private fun handleItemClickDetails(item:Result){
        Log.d("Tıklanan Öğe", item.title.toString())

        binding.recyclerView.visibility = View.GONE
        binding.earthquakeDetailsLayout.visibility = View.VISIBLE

        binding.magTV.text = item.mag.toString()
        binding.depthTV.text = item.depth.toString()
        binding.countryTV.text = item.title.toString()
        val minutesPassed = calculateMinutesPassed(item.date.toString())
        binding.minutesPassedTV.text = "$minutesPassed minutes ago"


    }

    private fun calculateMinutesPassed(dateTime: String): Long{
        val inputFormat = SimpleDateFormat("yyyy.MM.dd HH:mm:ss", Locale.getDefault())
        val currentDate = Date()
        val startDate = inputFormat.parse(dateTime)
        val difference = currentDate.time - startDate.time

        return Math.abs(difference / (60 * 1000)) // toplam milisaniye farkını dakika olarak hesaplar
    }

}