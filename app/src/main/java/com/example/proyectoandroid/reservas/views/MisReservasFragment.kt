package com.example.proyectoandroid.reservas.views

import android.content.DialogInterface
import android.os.Bundle
import android.view.KeyEvent
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.proyectoandroid.R
import com.example.proyectoandroid.databinding.FragmentMisReservasBinding
import com.example.proyectoandroid.incidencias.models.Incidencias
import com.example.proyectoandroid.incidencias.views.adapter.IncidenciasAdapter
import com.example.proyectoandroid.reservas.models.AulasProv
import com.example.proyectoandroid.reservas.models.Reservas
import com.example.proyectoandroid.reservas.models.ReservasProv
import com.example.proyectoandroid.reservas.models.Session

import com.example.proyectoandroid.reservas.viewmodels.ReservasViewModel
import com.example.proyectoandroid.reservas.views.adapter.ReservasAdapter


class MisReservasFragment : Fragment() {

    // referencia del archivo xml -> fragment_mis_reservas en la carpeta layout.
    private lateinit var  binding :  FragmentMisReservasBinding

    // referencia del viewModel creado en el fichero ReservasViewModels
    val reservasViewModelView : ReservasViewModel by viewModels()

    private lateinit var  adapter: ReservasAdapter

    var session: Session? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        arguments.let {

            session = Session(
                it?.getString("nombre").toString(),
                it?.getString("tipo").toString(),
                it?.getString("usuario").toString()
            )

        }

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMisReservasBinding.inflate(inflater, container,false)
        reservasViewModelView.getReservas()
        InitRecyclerView()
        return binding.root
    }

    //inicializa el recyclerView de reservas.
    private fun InitRecyclerView() {

        reservasViewModelView.listaReservas.observe(viewLifecycleOwner, Observer {
            val manager = LinearLayoutManager(context)
            if (session!!.rol == "Profesorado") {

                adapter = ReservasAdapter(reservasViewModelView.filtrarPorProfesor(session?.usuario.toString()) ) // ?: si la lista del viewmodel retorna null, envia una lista vacia.
                {
                        reserva -> EliminarReserva(reserva)
                }


            }else if (session!!.rol == "ED") {

                adapter = ReservasAdapter(reservasViewModelView.listaReservas.value!!.toList() ) // ?: si la lista del viewmodel retorna null, envia una lista vacia.
                {
                        reserva -> EliminarReserva(reserva)
                }

            }

            val decoration = DividerItemDecoration(context, manager.orientation) //crea la decoraci??n que va ha separar los items.
            binding.recyclerviewMisReservas.layoutManager = manager // a??ade el manager al recycler view.
            binding.recyclerviewMisReservas.adapter = adapter //a??ade el adapter al recycler view.
            binding.recyclerviewMisReservas.addItemDecoration(decoration) // a??ade la decoraci??n que va ha separar los items.
        })

    }

    // funci??n para eliminar la reservas.
    private  fun EliminarReserva(reserva : Reservas) {

        //obtenemos el aula tablets
        val aulaTablet = AulasProv.getAulaTablets()

        // funci??n lambda para el boton confirmar del dialogo.
        val botonOK =  { dialog : DialogInterface, witch : Int ->
            aulaTablet.CantidadDisponible += reserva.cantidadTablet
            ReservasProv.removeReservas(reserva)
            Toast.makeText(context, "Reserva eliminada" , Toast.LENGTH_SHORT).show()
            findNavController().navigate(R.id.misReservasFragment, args =  arguments)

        }



        // funci??n lambda para el boton cancelar del dialogo.

        val botonNoOK =  { dialog : DialogInterface, witch : Int ->

            dialog.dismiss()

        }


        //dialogo de confirmaci??n.

            val dialogoCerrarAPP = AlertDialog.Builder(requireContext())
            dialogoCerrarAPP.setMessage("??Seguro que desea eliminar la reserva?")
            dialogoCerrarAPP.setPositiveButton("Confirmar", DialogInterface.OnClickListener(botonOK))
            dialogoCerrarAPP.setNegativeButton("Cancelar", DialogInterface.OnClickListener(botonNoOK))
            dialogoCerrarAPP.show()


    }






    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val searchView = binding.searchViewReservas

        //listener del searchview permite filtrar por la fecha si tu rol es profesorado y por la fecha o usuario si eres ED

        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                query.let {

                    var listaFiltrada : List<Reservas> = emptyList()

                    if (session!!.rol == "Profesorado") {

                         listaFiltrada = reservasViewModelView.filtrarPorProfesor(session!!.usuario).filter { Reservas -> Reservas.fecha == query.toString()  }
                    }else if (session!!.rol == "ED") {

                         listaFiltrada = reservasViewModelView.listaReservas.value!!.filter {
                                 Reservas ->
                             Reservas.fecha == query.toString() ||
                             Reservas.profesor.lowercase() == query.toString().lowercase()

                         }

                    }

                    if (listaFiltrada.isNotEmpty()){

                        adapter.Update(listaFiltrada)

                    }
                    else {

                        adapter.Update(emptyList())
                    }


                }
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                newText.let {

                    if (session!!.rol == "Profesorado"){

                        adapter.Update(reservasViewModelView.filtrarPorProfesor(session!!.usuario))
                    }else if (session!!.rol == "ED") {

                        adapter.Update(reservasViewModelView.listaReservas.value!!.toList())

                    }


                }
                return false
            }

        })

    }


}