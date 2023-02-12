package com.example.proyectoandroid.reservas

import android.app.DatePickerDialog
import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.widget.DatePicker
import androidx.fragment.app.DialogFragment
import java.util.*

class SeleccionarFechaFragment (val listener: (day: Int, month: Int, year:Int)-> Unit): DialogFragment(),
    DatePickerDialog.OnDateSetListener {


    override fun onDateSet(p0: DatePicker?, sel_day: Int, sel_month: Int, sel_year: Int) {
        listener(sel_day,sel_month,sel_year)
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {

        val calendario = Calendar.getInstance()
        val day : Int = calendario.get(Calendar.DAY_OF_MONTH)
        val month : Int = calendario.get(Calendar.MONTH)
        val year : Int = calendario.get(Calendar.YEAR)

        val cursor = DatePickerDialog(activity as Context, this, year, month, day)
        cursor.datePicker.maxDate=calendario.timeInMillis+1209600000
        cursor.datePicker.minDate=calendario.timeInMillis
        return cursor

    }

}