package com.example.proyectoandroid.incidencias

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.proyectoandroid.R

class IncidendiasFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_incidendias, container, false)
    }
    fun initRecyclerView(){
        val recyclerView = view?.findViewById<RecyclerView>(R.id.inci_recyc)
        recyclerView?.layoutManager=LinearLayoutManager(context)

    }

}