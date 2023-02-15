package com.example.proyectoandroid.reservas

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.Toolbar
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupWithNavController
import com.example.proyectoandroid.R
import com.example.proyectoandroid.databinding.FragmentReservasMainMenuBinding


class reservasMainMenuFragment : Fragment() {

    private lateinit var binding : FragmentReservasMainMenuBinding
    private lateinit var toolbar : Toolbar

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