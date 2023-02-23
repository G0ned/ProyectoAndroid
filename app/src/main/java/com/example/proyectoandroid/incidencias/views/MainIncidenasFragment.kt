package com.example.proyectoandroid.incidencias.views

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupWithNavController
import com.example.proyectoandroid.R
import com.example.proyectoandroid.databinding.FragmentMainIncidenasBinding
import androidx.appcompat.widget.SearchView
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.viewModels
import com.example.proyectoandroid.incidencias.models.Incidencias
import com.example.proyectoandroid.incidencias.viewmodels.IncidenciasViewModel


class MainIncidenasFragment : Fragment() {
    // referencia a cualquier objeto del xml -> fragment_main_incidencias.xml en la carpeta layout.
    private lateinit var binding: FragmentMainIncidenasBinding
    // referencia de la toolbar de incidencias del xml -> toolbar_menu.xml en l carpeta menu.
    private lateinit var toolbar  : Toolbar

    // referencia al viewModels
    private val incidenciasViewModel : IncidenciasViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {


        binding = FragmentMainIncidenasBinding.inflate(inflater, container, false)

        toolbar = binding.ToolbarIncidencias
        val NavView = binding.BottomNavigationViewIncidencias
        //obtiene la referencias del NavHostFragment
        val navHostFragment =
            childFragmentManager.findFragmentById(R.id.fragmentContainerViewMainMenuIncidencias) as NavHostFragment
        // obtiene la referencia del navController
        val navController = navHostFragment.navController
        // construye la configuración de la app bar
        val builder = AppBarConfiguration.Builder(navController.graph)
        val appBarConfiguration = builder.build()
        toolbar.setupWithNavController(navController, appBarConfiguration)
        NavView.setupWithNavController(navController)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {


        toolbar.inflateMenu(R.menu.toolbar_menu)

        // referencia del search view  del tool bar.
        val buscador = toolbar.menu.findItem(R.id.action_search)
        val searchView = buscador.actionView as SearchView




        // listener del searchView.
        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener{
            override fun onQueryTextSubmit(query: String?): Boolean {
               query.let {
                   incidenciasViewModel.listaIncidencias.value?.filter { incidencias : Incidencias -> incidencias.profesor.lowercase().contains(query.toString()) }

               }
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                newText.let {

                    incidenciasViewModel.listaIncidencias.value?.filter { incidencias : Incidencias -> incidencias.profesor.lowercase().contains(newText.toString()) }

                }
                return false
            }


        })

    }










}













