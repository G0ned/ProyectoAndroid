package com.example.proyectoandroid.reservas.views

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import android.widget.AdapterView.OnItemSelectedListener
import androidx.fragment.app.viewModels
import com.example.proyectoandroid.R
import com.example.proyectoandroid.databinding.FragmentCrearReservaBinding
import com.example.proyectoandroid.reservas.models.Asignaturas
import com.example.proyectoandroid.reservas.models.Reservas
import com.example.proyectoandroid.reservas.models.ReservasProv
import com.example.proyectoandroid.reservas.models.Session
import com.example.proyectoandroid.reservas.viewmodels.AsignaturaViewModels
import com.example.proyectoandroid.reservas.viewmodels.ReservasViewModel
import kotlinx.coroutines.CoroutineScope
import java.text.DateFormat
import java.text.SimpleDateFormat
import java.util.*

class CrearReservaFragment : Fragment() {

    // referencia a al archivo xml -> fragment_crear_reservas.xml en la carpeta layout.
    private lateinit var binding: FragmentCrearReservaBinding

    val reservasViewModelView: ReservasViewModel by viewModels()

    val asignaturasViewModelView: AsignaturaViewModels by viewModels()

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

        reservasViewModelView.getReservas()
        asignaturasViewModelView.initAsignaturas()

        binding = FragmentCrearReservaBinding.inflate(inflater, container, false)
        println("####" + session?.usuario)


        binding.selFechaEt.setOnClickListener { mostrarCalendario() }
        // Inflate the layout for this fragment
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        when (session?.rol) {

            "Profesorado" -> {

                binding.profesorTextView.visibility = View.VISIBLE
                binding.profesorTextView.text = session?.nombre
                binding.aulasProf.visibility = View.VISIBLE


            }
            "ED" -> {

                binding.profesorTextView.text = "Usuario del profesor"
                binding.profesorEditText.visibility = View.VISIBLE
                binding.aulasEd.visibility = View.VISIBLE







            }

        }


        binding.reservarBtn.setOnClickListener {

            val result : Reservas? = crearReserva()

            if (result == null){
                Toast.makeText(context, "Ha ocurrido un error", Toast.LENGTH_SHORT).show()
             }else {
                ReservasProv.addReservas(result)
                Toast.makeText(context, "Reserva creada", Toast.LENGTH_SHORT).show()

            }

        }


    }


    // método que muestra el calendario.
    private fun mostrarCalendario() {

        val cursor_fecha =
            SeleccionarFechaFragment { day, month, year -> fechaElegida(day, month, year) }
        cursor_fecha.show(childFragmentManager, "cursor_fecha")
    }


    // método obtiene la fecha elegida por el usuario.
    fun fechaElegida(day: Int, month: Int, year: Int) {

        val fecha_texto = SimpleDateFormat("dd/MM/yyyy")
        val current_date = fecha_texto.format(Date("$day/${month + 1}/$year"))
        binding.selFechaEt.setText(current_date.toString())
        horasDisponibles(current_date.toString())

        if (session!!.rol == "Profesorado") {
            setAsignaturas(session!!.usuario)

        }else if (session!!.rol == "ED")
        {

        }


    }

    private fun horasDisponibles(fecha_texto: String) {

        val reservasDia =
            reservasViewModelView.listaReservas.value?.filter { Reservas -> Reservas.fecha == fecha_texto }
                ?: emptyList()

        val horasDisponibles = mutableListOf<String>("1", "2", "3", "4", "5", "6")


        reservasDia.forEach { reservas ->
            horasDisponibles.remove(reservas.hora)
        }


        binding.horaAReservas.adapter = ArrayAdapter<String>(
            requireContext(),
            android.R.layout.simple_spinner_dropdown_item,
            horasDisponibles
        )
    }


    private fun setAsignaturas(profesor: String) {

        val asignaturasDelProfesor =
            asignaturasViewModelView.listaAsignaturas.value?.filter { Asignaturas -> Asignaturas.profesor.lowercase() == profesor.lowercase() }
                ?: emptyList()

        val cursosGruposAsignaturas = mutableListOf(" ")

        val adapter = ArrayAdapter(
            requireContext(),
            android.R.layout.simple_spinner_dropdown_item,
            cursosGruposAsignaturas
        )

        asignaturasDelProfesor.forEach { Asignaturas ->
            adapter.add("${Asignaturas.nombre}-${Asignaturas.cursoGrupos}")


        }

        binding.SpinnerCursoGrupo.adapter = adapter


        binding.SpinnerCursoGrupo.onItemSelectedListener = object : OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {

                if (session!!.rol == "Profesorado") {


                    val seleccion: String = binding.SpinnerCursoGrupo.selectedItem.toString()

                    if (seleccion.contains("ESO") || seleccion.contains("FP")) {
                        binding.aulasProf.text = "MEDUSA1"

                    } else if (seleccion.contains("CFG") || seleccion.contains("BACH")) {
                        binding.aulasProf.text = "MEDUSA2"
                    }


                }


            }

            override fun onNothingSelected(parent: AdapterView<*>?) {

            }


        }

    }


    private fun crearReserva(): Reservas? {


       if (session!!.rol == "Profesorado") {

           return  Reservas(
                binding.selFechaEt.text.toString(),
                session!!.usuario,
                binding.SpinnerCursoGrupo.selectedItem.toString().split("-")[1],
                binding.profesorTextView.text.toString(),
                binding.horaAReservas.selectedItem.toString()
            )

        }
        else if (session!!.rol == "ED") {

           var nombreUser : String
            if ( binding.profesorEditText.text.toString() == "")
                    nombreUser = session!!.usuario
            else {
                nombreUser = binding.profesorEditText.text.toString()
            }


          return Reservas(
                binding.selFechaEt.toString(),
                nombreUser,
                binding.SpinnerCursoGrupo.selectedItem.toString(),
                binding.profesorTextView.text.toString(),
                binding.horaAReservas.selectedItem.toString()

            )

        }else  {

           return null
        }

    }
}


