package com.example.seminario2_di

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)

        //Prefiero esto a estar toqueteando el manifest
        val intent = Intent(this, Ej1Activity::class.java)
        startActivity(intent)
    }
}