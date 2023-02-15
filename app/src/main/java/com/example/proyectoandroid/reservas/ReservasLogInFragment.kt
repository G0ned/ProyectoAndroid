package com.example.proyectoandroid.reservas

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController

import com.example.proyectoandroid.R
import com.example.proyectoandroid.databinding.FragmentReservasLogInBinding

class ReservasLogInFragment : Fragment() {

    private lateinit var binding: FragmentReservasLogInBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentReservasLogInBinding.inflate(inflater, container, false)
        binding.button.setOnClickListener{
            if (binding.editTextTextPersonName.text.toString() =="Usuario" && binding.editTextTextPassword.text.toString()=="123"){
                view?.findNavController()?.navigate(R.id.action_reservasLogInFragment_to_crearReservaFragment)
            }
            else{
                Toast.makeText(context, "Credenciales incorrectas", Toast.LENGTH_SHORT).show()
            }
        }
        // Inflate the layout for this fragment
        return binding.root
    }

}