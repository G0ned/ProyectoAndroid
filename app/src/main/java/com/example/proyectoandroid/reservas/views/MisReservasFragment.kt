package com.example.proyectoandroid.reservas.views

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.proyectoandroid.R
import com.example.proyectoandroid.databinding.FragmentMisReservasBinding


class MisReservasFragment : Fragment() {

    private lateinit var  binding :  FragmentMisReservasBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMisReservasBinding.inflate(inflater, container,false)

        return binding.root
    }





}