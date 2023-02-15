package com.example.proyectoandroid.reservas

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.proyectoandroid.R
import com.example.proyectoandroid.databinding.FragmentReservasMainMenuBinding


class reservasMainMenuFragment : Fragment() {

    private lateinit var binding : FragmentReservasMainMenuBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding =  FragmentReservasMainMenuBinding.inflate(inflater, container, false)




        return binding.root
    }


}