package com.example.proyectoandroid.incidencias.views

import android.icu.util.Calendar
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
import java.text.SimpleDateFormat
import java.time.LocalDate
import java.util.*


class CrearIncidenciaFragment : Fragment() {

   //referencia del archivo  xml -> fragment_crear_incidencia.xml en la carpeta layout.
    private lateinit var  binding: FragmentCrearIncidenciaBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCrearIncidenciaBinding.inflate(inflater,container,false)

        // listener del boton para crear la incidena.
        binding.buttonCrearIncidencia.setOnClickListener {
            IncidenciasProv.addIncidencia(createIncidencia())
            Toast.makeText(context, "Incidencia creada.", Toast.LENGTH_SHORT).show()
            view?.findNavController()?.navigate(R.id.action_crearIncidenciaFragment_to_incidenciasFragment)
        }

        //listener del boton para limpiar la incidenca
        binding.buttonLimpiarIncidencia.setOnClickListener {
            limpiarPantalla()
        }

        return  binding.root
    }

    // método que crea un objeto de la Data class Incidencias.
    private fun createIncidencia() : Incidencias {

        val sdf = SimpleDateFormat("dd/MM/yyyy")
        val currentDate = sdf.format(Date())

        return Incidencias(
            currentDate.toString(),
            binding.descripcionContent.text.toString(),
            binding.codigoaulaContent.text.toString(),
            binding.codigoequipoContent.text.toString(),

        )

    }
    // método que pone el valor de los campos a vacio.
    private  fun limpiarPantalla() {
        binding.descripcionContent.text = null
        binding.codigoaulaContent.text = null
        binding.codigoequipoContent.text = null
    }
}