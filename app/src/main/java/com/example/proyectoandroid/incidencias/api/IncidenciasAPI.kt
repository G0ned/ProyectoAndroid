package com.example.proyectoandroid.incidencias.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class IncidenciasAPI {


     fun createRetrofit() : Retrofit {

        return Retrofit.Builder()
            .baseUrl("")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    }



}