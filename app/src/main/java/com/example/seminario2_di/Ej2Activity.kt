package com.example.seminario2_di

import android.os.Bundle
import android.os.CountDownTimer
import android.util.Log
import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.children
import kotlinx.coroutines.delay

class Ej2Activity : AppCompatActivity() {
    private lateinit var contenedorCartas: LinearLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_ej2)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        contenedorCartas = findViewById<LinearLayout>(R.id.contenedorCartas)

        contenedorCartas.children.forEach {
            var imageView: ImageView = it as ImageView

            var identificador = applicationContext.resources.getResourceName(imageView.id).split("/")[1]

            imageView.setOnClickListener {
                when(identificador){
                    "carta1" -> imageView.setImageResource(R.drawable.carta1)
                    "carta2" -> imageView.setImageResource(R.drawable.carta2)
                    "carta3" -> imageView.setImageResource(R.drawable.carta3)
                }

                object : CountDownTimer(1000, 1000){
                    override fun onTick(millisUntilFinished: Long) {}

                    override fun onFinish() {
                        imageView.setImageResource(R.drawable.reverso_naipe)
                    }
                }.start()
            }
        }
    }
}