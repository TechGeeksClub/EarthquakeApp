package com.techgeeksclub.earthquake.ui.fragment

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.techgeeksclub.earthquake.databinding.FragmentEmergencyBinding
import com.techgeeksclub.earthquake.ui.adapter.EmergencyAdapter
import com.techgeeksclub.earthquake.ui.viewmodel.EmergencyViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class EmergencyFragment : Fragment() {

    private lateinit var viewModel: EmergencyViewModel
    private lateinit var binding: FragmentEmergencyBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val tempViewModel : EmergencyViewModel by viewModels()
        viewModel = tempViewModel
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentEmergencyBinding.inflate(inflater)

        val layoutManager = LinearLayoutManager(context)
        binding.rv.layoutManager = layoutManager

        viewModel.emergencyItems.observe(viewLifecycleOwner){
            val adapter = EmergencyAdapter(requireContext(),it)
            binding.rv.adapter = adapter
        }


        return binding.root
    }


}