package com.example.ciclodevida

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

const val TAG = "Estado Ciclo de Vida"

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(
            R.layout.activity_main

                    Log . i (TAG, "onCreate : estado Ciclode Vida - ${this.lifecycle.currentState}"
        )

    }

    override fun onStart() {
        super.onStart()
        Log.i(TAG, "onStart : estado Ciclode Vida - ${this.lifecycle.currentState}")
    }

    override fun onResume() {
        super.onResume()
        Log.i(TAG, "onResume: estado Ciclode Vida - ${this.lifecycle.currentState}")
    }

    override fun onPause() {
        super.onPause()
        Log.i(TAG, "onPause: estado Ciclode Vida - ${this.lifecycle.currentState}")
    }

    override fun onStop() {
        super.onStop()
        Log.i(TAG, "onStop: estado Ciclode Vida - ${this.lifecycle.currentState}")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i(TAG, "onDestroy: estado Ciclode Vida - ${this.lifecycle.currentState}")
    }

    override fun onRestart() {
        super.onRestart()
        Log.i(TAG, "onRestart: estado Ciclode Vida - ${this.lifecycle.currentState}")
    }
}