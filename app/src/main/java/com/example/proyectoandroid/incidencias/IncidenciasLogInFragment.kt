package com.example.proyectoandroid.incidencias

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.proyectoandroid.R
import com.example.proyectoandroid.databinding.FragmentIncidenciasLogInBinding

class IncidenciasLogInFragment : Fragment() {

    private lateinit var binding : FragmentIncidenciasLogInBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding =  FragmentIncidenciasLogInBinding.inflate(inflater, container, false)
        return binding.root
    }



}