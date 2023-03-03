package com.example.proyectoandroid.reservas.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.proyectoandroid.reservas.models.Usuarios
import com.example.proyectoandroid.reservas.models.UsuariosProv

class UsuariosViewModels : ViewModel() {


    private var listaUsuarios = MutableLiveData<MutableList<Usuarios>>(
        UsuariosProv.ListaDeUsuarios
    )


    fun validarUsuario(Usuario: String, Clave : String) : Usuarios? {

       val usuarioFiltrado =  listaUsuarios.value?.filter { Usuarios -> Usuarios.usuario.lowercase() == Usuario.lowercase() && Usuarios.clave == Clave } ?: emptyList()

        if  (usuarioFiltrado.isEmpty() ) {

            return null

        }
        else {

            return usuarioFiltrado.last()
        }


    }



}