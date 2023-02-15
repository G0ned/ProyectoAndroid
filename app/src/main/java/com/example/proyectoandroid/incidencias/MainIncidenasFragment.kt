package com.example.proyectoandroid.incidencias

import android.app.Activity
import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration

import androidx.navigation.ui.setupWithNavController
import com.example.proyectoandroid.R
import com.example.proyectoandroid.databinding.FragmentMainIncidenasBinding

import android.widget.Toast
import androidx.appcompat.widget.SearchView
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.setFragmentResultListener
import androidx.fragment.app.viewModels
import com.example.proyectoandroid.incidencias.viewmodels.IncidenciasList


class MainIncidenasFragment : Fragment() {

    private lateinit var binding: FragmentMainIncidenasBinding
    private lateinit var toolbar  : Toolbar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {


        binding = FragmentMainIncidenasBinding.inflate(inflater, container, false)

        toolbar = binding.ToolbarIncidencias
        val NavView = binding.BottomNavigationViewIncidencias
        val navHostFragment =
            childFragmentManager.findFragmentById(R.id.fragmentContainerViewMainMenuIncidencias) as NavHostFragment
        val navController = navHostFragment.navController
        val builder = AppBarConfiguration.Builder(navController.graph)
        val appBarConfiguration = builder.build()
        toolbar.setupWithNavController(navController, appBarConfiguration)
        NavView.setupWithNavController(navController)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {


        toolbar.inflateMenu(R.menu.toolbar_menu)

        val buscador = toolbar.menu.findItem(R.id.action_search)
        val searchView = buscador.actionView as SearchView


        val incidenciasList : IncidenciasList by activityViewModels()


        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener{
            override fun onQueryTextSubmit(query: String?): Boolean {
               query.let {
                   incidenciasList.list_Origen.filter { incidencias : Incidencias -> incidencias.profesor.lowercase().contains(query.toString()) }

               }
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                newText.let {

                    incidenciasList.list_Origen = incidenciasList.list_Origen.filter { incidencias : Incidencias -> incidencias.profesor.lowercase().contains(newText.toString()) }

                }
                return false
            }


        })

    }










}













