package com.example.proyectoandroid

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.add
import androidx.fragment.app.commit

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        // comprobando esto no se generan 2 pantallas a la hora de rotar la pantalla.
        if (savedInstanceState == null) {

            supportFragmentManager.commit {
                setReorderingAllowed(true)
                add<InicioFragment>(R.id.fragmentContainerView)
            }

        }

    }
}