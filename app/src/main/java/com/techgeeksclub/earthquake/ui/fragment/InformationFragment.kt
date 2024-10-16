package com.techgeeksclub.earthquake.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.techgeeksclub.earthquake.data.entity.EmergencyItem
import com.techgeeksclub.earthquake.databinding.FragmentEmergencyBinding
import com.techgeeksclub.earthquake.databinding.FragmentInformationBinding
import com.techgeeksclub.earthquake.ui.adapter.EmergencyAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class InformationFragment : Fragment() {

    private lateinit var binding: FragmentInformationBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentInformationBinding.inflate(inflater)


        binding.backButton.setOnClickListener { handleBackButtonClick() }


        return binding.root
    }


    private fun handleBackButtonClick(){

        //navigate back to emergency fragment
        findNavController().popBackStack() // Navigate back

    }
}