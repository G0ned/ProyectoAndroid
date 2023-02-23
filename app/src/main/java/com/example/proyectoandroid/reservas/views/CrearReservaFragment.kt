package com.example.proyectoandroid.reservas.views

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.proyectoandroid.databinding.FragmentCrearReservaBinding

class CrearReservaFragment : Fragment() {

    // referencia a al archivo xml -> fragment_crear_reservas.xml en la carpeta layout.
    private lateinit var binding : FragmentCrearReservaBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCrearReservaBinding.inflate(inflater, container, false)
        binding.selFechaEt.setOnClickListener{mostrarCalendario()}
        // Inflate the layout for this fragment
        return binding.root
    }

    // método que muestra el calendario.
    private fun mostrarCalendario(){

        val cursor_fecha = SeleccionarFechaFragment{day, month, year -> fechaElegida(day, month, year)}
        cursor_fecha.show(childFragmentManager, "cursor_fecha")
    }


    // método obtiene la fecha elegida por el usuario.
    fun fechaElegida(day:Int, month:Int, year:Int){
        val new_month=month+1
        binding.selFechaEt.setText("$year-$new_month-$day")
    }
}