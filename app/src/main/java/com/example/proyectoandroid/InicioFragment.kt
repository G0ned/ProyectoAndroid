package com.example.proyectoandroid

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.*
import androidx.navigation.findNavController


class InicioFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

         val view = inflater.inflate(R.layout.fragment_inicio, container, false)

        val button_incidencias = view?.findViewById<Button>(R.id.incidencias_button)
        val button_reservas =  view?.findViewById<Button>(R.id.reservas_button)

        button_incidencias?.setOnClickListener {
            view?.findNavController()?.navigate(R.id.action_inicioFragment_to_incidendiasFragment)
        }

        button_reservas?.setOnClickListener {
            view?.findNavController()?.navigate(R.id.action_inicioFragment_to_reservasLogInFragment)

        }

        return view
    }


}