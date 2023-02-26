package com.example.proyectoandroid.reservas.views

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.Toolbar
import androidx.core.os.bundleOf
import androidx.fragment.app.setFragmentResult
import androidx.fragment.app.setFragmentResultListener
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupWithNavController
import com.example.proyectoandroid.R
import com.example.proyectoandroid.databinding.FragmentReservasMainMenuBinding


class reservasMainMenuFragment : Fragment() {


    // referencia del archivo xml -> fragment_reservas_main_menu.xml en la carpeta layout
    private lateinit var binding : FragmentReservasMainMenuBinding
    // referencia del archivo xml -> toolbar_menu_reservas.xml en la carpeta menu.
    private lateinit var toolbar : Toolbar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        var bundle : Bundle

        arguments.let {

         bundle = bundleOf(
                "nombre" to  it!!.getString("nombre").toString(),
                "rol" to  it!!.getString("tipo").toString()
            )

        }

      childFragmentManager.setFragmentResult("session", bundle )

    }


    // Al crear la vista se monta el navView y el toolBar en la interfaz del recycler view.

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {



        binding =  FragmentReservasMainMenuBinding.inflate(inflater, container, false)

        toolbar = binding.ToolbarReservas
        val NavView = binding.BottomNavigationViewReservas
        val navHostFragment =
            childFragmentManager.findFragmentById(R.id.fragmentContainerViewMainMenuReservas) as NavHostFragment
        val navController = navHostFragment.navController

        val builder = AppBarConfiguration.Builder(navController.graph)
        val appBarConfiguration = builder.build()
        toolbar.setupWithNavController(navController, appBarConfiguration)
        NavView.setupWithNavController(navController)




        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        toolbar.inflateMenu(R.menu.toolbar_menu_reservas)

    }


}