package com.example.proyectoandroid.incidencias.views

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentResultListener
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.example.proyectoandroid.R
import com.example.proyectoandroid.databinding.FragmentVerIncidenciasBinding
import com.example.proyectoandroid.incidencias.models.Incidencias
import com.example.proyectoandroid.incidencias.viewmodels.IncidenciasViewModel


class VerIncidenciasFragment : Fragment() {

    private  lateinit var binding : FragmentVerIncidenciasBinding
    private  lateinit var  incidencia : Incidencias

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // se recogen los parametros que se envian al cambiar de fragmento en el archivo -> IncidenciasFragment en el método de goToFullObject.
        arguments?.let {
           incidencia = Incidencias(
               it.getString("fechaIncidencia").toString(),
               it.getString("descripcion").toString(),
               it.getString("codAula").toString(),
               it.getString("codEquipo").toString()
           )
        }
    }
    
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
       binding =   FragmentVerIncidenciasBinding.inflate(inflater, container, false)
        setData(incidencia)
        return  binding.root
    }

    // distribuye la información obtenida por el bundle a sus campos correspondientes.
    private fun setData(incidencia : Incidencias) {
        binding.descIncContent.text = incidencia.descripcion
        binding.fechaIncContent.text = incidencia.fechaIncidencias
        binding.codaulaIncContent.text = incidencia.codAula
        binding.codequipoIncContent.text = incidencia.codEquipo

    }

}