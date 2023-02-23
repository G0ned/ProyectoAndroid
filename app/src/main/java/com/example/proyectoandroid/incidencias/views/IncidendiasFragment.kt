package com.example.proyectoandroid.incidencias.views

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.proyectoandroid.R
import com.example.proyectoandroid.databinding.FragmentIncidendiasBinding
import com.example.proyectoandroid.incidencias.models.Incidencias
import com.example.proyectoandroid.incidencias.views.adapter.IncidenciasAdapter
import com.example.proyectoandroid.incidencias.viewmodels.IncidenciasViewModel

class IncidendiasFragment : Fragment() {
    //referencia del archivo xml -> fragment_incidencias.xml  en la carpeta layout
    private lateinit var binding: FragmentIncidendiasBinding
    //referencia del ViewModel del archivo IncidenciasViewModel
    val incidenciasViewModel :IncidenciasViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentIncidendiasBinding.inflate(inflater,container,false)
        incidenciasViewModel.getIncidencias()
        initRecyclerView()
        return  binding.root


    }

    //metodo que inicializa los elementos del recyclerview siempre que la lista "listaIncidencia" del viewmodels es modificada.
    private fun initRecyclerView(){

        // Observer que se ejecuta cuando en la listaIncidencia del archivo incidenciasViewModel.kt en la carpeta incidencias/views, es modificado.
        incidenciasViewModel.listaIncidencias.observe(viewLifecycleOwner, Observer {
            val manager = LinearLayoutManager(context)
            val adapter = IncidenciasAdapter(incidenciasViewModel.listaIncidencias.value?.toList() ?: emptyList()) // ?: si listaIncidencia devuelve null usa emptyList()
            {
                    incidencia -> goToFullObject(incidencia)
            }
            val decoration = DividerItemDecoration(context,manager.orientation) // genera el item que va ha dividir los Items.
            binding.recyclerview.layoutManager=  manager //  añade el manager al recycler view.
            binding.recyclerview.adapter = adapter // añade el adapter al manager al recycler view.
            binding.recyclerview.addItemDecoration(decoration) // añade el item de decoración al recycler view.
        })


    }



    //método  que envía la información del item selecionado al fragmento de verIncidenciasFragment.
    fun goToFullObject( incidencias: Incidencias) {
        Toast.makeText(context,incidencias.profesor, Toast.LENGTH_SHORT).show()
        // bundle para pasar la información al otro fragmento.
        val bundle = bundleOf(
            "profesor" to incidencias.profesor,
            "descripcion" to incidencias.descripcion,
            "fecha" to  incidencias.fecha

        )
        // referencia del navController del archivo xml -> nav_menu_incidencias.xml en la carpeta navigation.
        // Se pasa un parametro bundle como args  para pasar información necesaria con la que va a trabajar el otro fragmento.
        view?.findNavController()?.navigate(R.id.action_incidenciasFragment_to_verIncidenciasFragment, args = bundle)

    }

}