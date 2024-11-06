package com.example.seminario2_di

import android.os.Bundle
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class Ej3Activity : AppCompatActivity() {
    private lateinit var imgSemaforo: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_ej3)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        lifecycleScope.launch {
            imgSemaforo = findViewById<ImageView>(R.id.semaforo)

            var ciclo: Map<Int, Long> = mapOf(
                R.drawable.semaforo_verde to 2000,
                R.drawable.semaforo_amarillo to 1000,
                R.drawable.semaforo_rojo to 2000
            )

            while(true) {
                ciclo.forEach { (imagen, tiempo) ->
                    imgSemaforo.setImageResource(imagen)

                    delay(tiempo)
                }
            }
        }
    }
}