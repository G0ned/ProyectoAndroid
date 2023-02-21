package com.example.proyectoandroid.incidencias.views

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.findNavController
import com.example.proyectoandroid.R
import com.example.proyectoandroid.databinding.FragmentCrearIncidenciaBinding
import com.example.proyectoandroid.incidencias.models.Incidencias
import com.example.proyectoandroid.incidencias.models.IncidenciasProv


class CrearIncidenciaFragment : Fragment() {

    private lateinit var  binding: FragmentCrearIncidenciaBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCrearIncidenciaBinding.inflate(inflater,container,false)

        binding.buttonCrearIncidencia.setOnClickListener {
            IncidenciasProv.addIncidencia(createIncidencia())
            Toast.makeText(context, "Incidencia creada.", Toast.LENGTH_SHORT).show()
            view?.findNavController()?.navigate(R.id.action_crearIncidenciaFragment_to_incidenciasFragment)
        }

        binding.buttonLimpiarIncidencia.setOnClickListener {
            limpiarPantalla()
        }




        return  binding.root
    }

    private fun createIncidencia() : Incidencias {

        return Incidencias(
            "11-11-2011",
            binding.profesorContent.text.toString(),
            binding.descripcionContent.text.toString()
        )

    }

    private  fun limpiarPantalla() {
        binding.profesorContent.text = null
        binding.descripcionContent.text = null
        binding.codigoaulaContent.text = null
        binding.codigoequipoContent.text = null
    }
}