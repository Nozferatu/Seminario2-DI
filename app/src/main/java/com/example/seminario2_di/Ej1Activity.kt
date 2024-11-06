package com.example.seminario2_di

import android.content.Intent
import android.os.Bundle
import android.os.CountDownTimer
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Ej1Activity : AppCompatActivity() {
    private var contexto = this

    private lateinit var contador: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_ej1)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        contador = findViewById<TextView>(R.id.contador)

        var tiempo: Long = 10

        var contadorCountDown = object : CountDownTimer(tiempo * 1000, 1000){
            override fun onTick(p0: Long) {
                contador.text = tiempo.toString()
                tiempo--
            }

            override fun onFinish() {
                val intent = Intent(contexto, Ej1BoomActivity::class.java)
                startActivity(intent)
            }

        }.start()
    }
}