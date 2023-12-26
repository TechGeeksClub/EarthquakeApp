package com.techgeeksclub.earthquake.ui.fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.techgeeksclub.earthquake.data.entity.Earthquake
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.techgeeksclub.earthquake.databinding.FragmentHomeBinding
import com.techgeeksclub.earthquake.data.repository.EarthquakeRepository
import com.techgeeksclub.earthquake.ui.adapter.EarthquakeRecyclerView
import com.techgeeksclub.earthquake.ui.viewmodel.HomeViewModel


class HomeFragment : Fragment(), OnMapReadyCallback {
    private lateinit var viewModel: HomeViewModel
    private lateinit var binding: FragmentHomeBinding
    private var adapter : EarthquakeRecyclerView? = null
    private var mMap: GoogleMap? = null
    private lateinit var list : ArrayList<Earthquake>


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(inflater)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val linearLayoutManager :  LinearLayoutManager = LinearLayoutManager(context)
        binding.recyclerView.layoutManager = linearLayoutManager
        adapter = EarthquakeRecyclerView(list)
        binding.recyclerView.adapter = adapter
        val mapFragment = childFragmentManager.findFragmentById(com.techgeeksclub.earthquake.R.id.map) as SupportMapFragment?
        mapFragment?.getMapAsync(this)
        val earthquakeRepository = EarthquakeRepository()
        earthquakeRepository.getEarthquakes(
            onSuccess = {
                it.result.forEach {
                    Log.d("Eartquake",it.title.toString())
                    Log.d("Eartquake",it.mag.toString())
                    Log.d("Eartquake",it.depth.toString())


                }
            },
            onFailure = {
                Log.d("Eartquake",it.message.toString())

            }
        )

    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(HomeViewModel::class.java)
    }

    override fun onMapReady(p0: GoogleMap) {
        mMap = p0
        // Add a marker in Sydney and move the camera
        val sydney = LatLng(36.8732452, 30.8206177)
        mMap!!.addMarker(
            MarkerOptions()
                .position(sydney)
                .title("Marker in Sydney")
        )
        mMap!!.moveCamera(CameraUpdateFactory.newLatLng(sydney))
    }

}