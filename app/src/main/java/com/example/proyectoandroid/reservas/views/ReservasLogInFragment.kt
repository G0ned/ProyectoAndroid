package com.example.proyectoandroid.reservas.views

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.findNavController
import com.example.proyectoandroid.R
import com.example.proyectoandroid.databinding.FragmentReservasLogInBinding
import com.example.proyectoandroid.reservas.models.Usuarios
import com.example.proyectoandroid.reservas.viewmodels.UsuariosViewModels


class ReservasLogInFragment : Fragment() {

    //referencia para el archivo xml -> fragmento_reservas_log_im.xml en la carpeta layout
    private lateinit var binding: FragmentReservasLogInBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentReservasLogInBinding.inflate(inflater, container, false)
        val usuariosViewModels  : UsuariosViewModels by viewModels()
        binding.button.setOnClickListener{
            //valida el campo de usuarios si es correcto manda al usuario al otro fragmento.



            val usuarioValidado : Usuarios? = usuariosViewModels.validarUsuario(binding.editTextTextPersonName.text.toString(), binding.editTextTextPassword.text.toString())

            if (usuarioValidado != null){


                val bundle = bundleOf(
                    "nombre" to usuarioValidado.nombre,
                    "tipo" to usuarioValidado.tipo,
                    "usuario" to usuarioValidado.usuario

                )
                view?.findNavController()?.navigate(R.id.action_reservasLogInFragment_to_reservasMainMenuFragment, args = bundle)
            }
            else{
                Toast.makeText(context, "Credenciales incorrectas", Toast.LENGTH_SHORT).show()
            }
        }
        // Inflate the layout for this fragment
        return binding.root
    }

}