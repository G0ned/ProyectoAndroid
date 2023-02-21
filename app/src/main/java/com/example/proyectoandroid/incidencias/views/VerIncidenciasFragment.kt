package com.example.proyectoandroid.incidencias.views

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.proyectoandroid.R
import com.example.proyectoandroid.databinding.FragmentVerIncidenciasBinding

class VerIncidenciasFragment : Fragment() {

    private  lateinit var binding : FragmentVerIncidenciasBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment


       binding =   FragmentVerIncidenciasBinding.inflate(inflater, container, false)
        return  binding.root
    }


}