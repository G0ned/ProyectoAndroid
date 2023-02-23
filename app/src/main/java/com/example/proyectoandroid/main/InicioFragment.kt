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

    // referencia del archivo xml -> fragment_inicio.xml en la carpeta layout.
    private lateinit var binding : FragmentInicioBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {


         binding = FragmentInicioBinding.inflate(inflater, container, false)


        // listener para incidenciasButton
        binding.incidenciasButton.setOnClickListener {
            // referencia del navigate del archivo xml -> nav.xml, en la carpeta navigation.
            // utiliza una accion del navigation para cambiar de fragmento.
            view?.findNavController()?.navigate(R.id.action_inicioFragment_to_mainIncidenasFragment)
        }

        // listener para reservasButton

        binding.reservasButton.setOnClickListener {
            // referencia del navigate del archivo xml -> nav.xml, en la carpeta navigation.
            // utiliza una accion del navigation para cambiar de fragmento.
            view?.findNavController()?.navigate(R.id.action_inicioFragment_to_reservasLogInFragment)

        }

        return binding.root
    }


}