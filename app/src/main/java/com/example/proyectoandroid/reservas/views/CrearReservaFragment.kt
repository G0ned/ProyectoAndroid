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
import com.example.proyectoandroid.reservas.models.*
import com.example.proyectoandroid.reservas.viewmodels.AsignaturaViewModels
import com.example.proyectoandroid.reservas.viewmodels.ReservasViewModel
import com.example.proyectoandroid.reservas.viewmodels.UsuariosViewModels
import kotlinx.coroutines.CoroutineScope
import java.text.DateFormat
import java.text.SimpleDateFormat
import java.util.*

class CrearReservaFragment : Fragment() {

    // referencia a al archivo xml -> fragment_crear_reservas.xml en la carpeta layout.
    private lateinit var binding: FragmentCrearReservaBinding

    val reservasViewModelView: ReservasViewModel by viewModels()

    val asignaturasViewModelView: AsignaturaViewModels by viewModels()

    val usuariosViewModels: UsuariosViewModels by viewModels()

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

                binding.profesorTextView.isEnabled = true
                binding.profesorTextView.visibility = View.VISIBLE
                binding.profesorTextView.textSize = 20f
                binding.profesorTextView.text = session?.usuario


            }
            "ED" -> {
                binding.profesorEditText.isEnabled = true
                binding.profesorEditText.visibility = View.VISIBLE


            }

        }


        binding.reservarBtn.setOnClickListener {

            val result : Reservas? = crearReserva()

            if (result == null){
                Toast.makeText(context, "Ha ocurrido un error", Toast.LENGTH_SHORT).show()
             }else {
                ReservasProv.addReservas(result)
                Toast.makeText(context, "Reserva creada", Toast.LENGTH_SHORT).show()
                limpiarVentana()
            }

        }

        binding.limpiarBtn.setOnClickListener {
            limpiarVentana()
        }

    }


    // método que muestra el calendario.
    private fun mostrarCalendario() {

        val cursor_fecha =
            SeleccionarFechaFragment { day, month, year -> fechaElegida(day, month, year) }
        cursor_fecha.show(childFragmentManager, "cursor_fecha")
    }


    private fun limpiarVentana(){
        binding.profesorEditText.text = null
        binding.selFechaEt.text = null
        binding.aulas.adapter = null
        binding.SpinnerCursoGrupo.adapter = null
        binding.horaAReservas.adapter = null
        binding.cantidadTabletsEd.text = null
        binding.cantidadtabletsEt.visibility = View.GONE
        binding.cantidadTabletsEd.visibility = View.GONE

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

            if ( binding.profesorEditText.text.toString() == "") {

                setAsignaturas(session!!.usuario)

            }
            else {

                setAsignaturas(binding.profesorEditText.text.toString())

            }


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

        val asignaturasDelProfesor : List<Asignaturas>


        if (profesor == "EquipoDirectivo" ) {

            asignaturasDelProfesor =
                asignaturasViewModelView.listaAsignaturas.value?.toList() ?: emptyList()

        }else{

            asignaturasDelProfesor =
                asignaturasViewModelView.listaAsignaturas.value?.filter { Asignaturas -> Asignaturas.profesor.lowercase() == profesor.lowercase() }
                    ?: emptyList()

        }


        val cursosGruposAsignaturas = mutableListOf<String>()

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

                    val  listaAulas = mutableListOf<String>()

                    val seleccion: String = binding.SpinnerCursoGrupo.selectedItem.toString()

                    if (seleccion.contains("ESO") || seleccion.contains("FP")) {

                        listaAulas.addAll(listOf("MEDUSA1","TABLETS"))

                    } else if (seleccion.contains("CFG") || seleccion.contains("BACH")) {
                        listaAulas.addAll(listOf("MEDUSA2","TABLETS"))
                    }

                    binding.aulas.adapter = ArrayAdapter<String>(requireContext(), android.R.layout.simple_spinner_dropdown_item, listaAulas)


                }
                else if ( session!!.rol == "ED" ){

                    val  listaAulas = mutableListOf<String>()

                    val adapter = ArrayAdapter(requireContext(),android.R.layout.simple_spinner_dropdown_item,listaAulas)

                    AulasProv.listaAulas.forEach{

                        Aulas -> adapter.add(Aulas.codigo)

                    }

                    binding.aulas.adapter = adapter

                }
                Tabets()


            }

            override fun onNothingSelected(parent: AdapterView<*>?) {

            }


        }

    }


    private fun crearReserva(): Reservas? {


        if (binding.selFechaEt.text.toString() != "") {

            var cantidadTablets : Int = 0


            if (binding.aulas.selectedItem.toString() == "TABLETS"){

                val aulaTablets : Aulas =  AulasProv.getAulaTablets()

                if (aulaTablets.CantidadDisponible - binding.cantidadTabletsEd.text.toString().toInt() >= 0) {

                    aulaTablets.CantidadDisponible -= binding.cantidadTabletsEd.text.toString().toInt()

                    cantidadTablets = binding.cantidadTabletsEd.text.toString().toInt()

                }
                else {
                    return null
                }

            }



            if (session!!.rol == "Profesorado") {


                return Reservas(
                    binding.selFechaEt.text.toString(),
                    session!!.usuario,
                    binding.SpinnerCursoGrupo.selectedItem.toString().split("-")[1],
                    binding.aulas.selectedItem.toString(),
                    binding.horaAReservas.selectedItem.toString(),
                    cantidadTablets
                )

            } else if (session!!.rol == "ED") {

                var nombreUser: String?
                if (binding.profesorEditText.text.toString() == "")
                    nombreUser = session!!.usuario
                else {
                    nombreUser =
                        usuariosViewModels.obtenerUsuario(binding.profesorEditText.text.toString())?.usuario ?: null

                    if (nombreUser == null) {

                        return  null
                    }

                }


                return Reservas(
                    binding.selFechaEt.text.toString(),
                    nombreUser!!,
                    binding.SpinnerCursoGrupo.selectedItem.toString().split("-")[1],
                    binding.aulas.selectedItem.toString(),
                    binding.horaAReservas.selectedItem.toString(),
                    cantidadTablets

                )

            } else {

                return null
            }

        }
        else {

            return null

        }
    }


    private fun Tabets(){

        binding.aulas.onItemSelectedListener = object : OnItemSelectedListener {

            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {

                if (binding.aulas.selectedItem.toString() == "TABLETS") {

                    binding.cantidadtabletsEt.visibility = View.VISIBLE
                    binding.cantidadTabletsEd.visibility = View.VISIBLE

                }else {

                    binding.cantidadtabletsEt.visibility = View.GONE
                    binding.cantidadTabletsEd.visibility = View.GONE

                }


            }

            override fun onNothingSelected(parent: AdapterView<*>?) {

            }

        }

    }

}


