package com.example.proyectoandroid.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.*
import androidx.navigation.findNavController
import com.example.proyectoandroid.R
import com.example.proyectoandroid.databinding.FragmentInicioBinding


class InicioFragment : Fragment() {

    private lateinit var binding : FragmentInicioBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {


         binding = FragmentInicioBinding.inflate(inflater, container, false)



        binding.incidenciasButton.setOnClickListener {
            view?.findNavController()?.navigate(R.id.action_inicioFragment_to_mainIncidenasFragment)
        }

        binding.reservasButton.setOnClickListener {
            view?.findNavController()?.navigate(R.id.action_inicioFragment_to_reservasLogInFragment)

        }

        return binding.root
    }


}