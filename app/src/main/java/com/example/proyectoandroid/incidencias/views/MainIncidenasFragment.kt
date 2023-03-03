package com.example.proyectoandroid.incidencias.views

import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupWithNavController
import com.example.proyectoandroid.R
import com.example.proyectoandroid.databinding.FragmentMainIncidenasBinding
import androidx.appcompat.widget.SearchView
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.viewModels
import com.example.proyectoandroid.databinding.FragmentIncidendiasBinding
import com.example.proyectoandroid.databinding.FragmentVerIncidenciasBinding
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
        navController.setGraph(R.navigation.nav_menu_incidencias)
        // construye la configuración de la app bar
        val builder = AppBarConfiguration.Builder(navController.graph)
        val appBarConfiguration = builder.build()
        toolbar.setupWithNavController(navController, appBarConfiguration)
        NavView.setupWithNavController(navController)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {


        toolbar.inflateMenu(R.menu.toolbar_menu)



    }










}













