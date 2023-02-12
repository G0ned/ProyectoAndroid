package com.example.proyectoandroid.incidencias

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



class MainIncidenasFragment : Fragment() {

    private lateinit var binding: FragmentMainIncidenasBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {


        binding = FragmentMainIncidenasBinding.inflate(inflater, container, false)

        val toolBar = binding.ToolbarIncidencias
        val NavView = binding.BottomNavigationViewIncidencias
        val navHostFragment =
            childFragmentManager.findFragmentById(R.id.fragmentContainerViewMainMenuIncidencias) as NavHostFragment
        val navController = navHostFragment.navController
        val builder = AppBarConfiguration.Builder(navController.graph)
        val appBarConfiguration = builder.build()
        toolBar.setupWithNavController(navController, appBarConfiguration)
        NavView.setupWithNavController(navController)
        return binding.root
    }

}













