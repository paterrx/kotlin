package com.gabriel.calculoalcoolgasolina

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val btnCalcular = findViewById<Button>(R.id.botao)
        val txtAlcool = findViewById<EditText>(R.id.editAlcool)
        val txtGasolina = findViewById<EditText>(R.id.editGasolina)
        val txtResultado = findViewById<TextView>(R.id.txtResultado)
        btnCalcular.setOnClickListener(){
            val valorAlcool = txtAlcool.text.toString().toDoubleOrNull()
            val valorGasolina = txtGasolina.text.toString().toDoubleOrNull()


            if(valorAlcool == null || valorGasolina == null){
                Toast.makeText(applicationContext, "Preencha todos os campos com números válidos", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }else{
                val resultado =calculoAlcoolGasolina(valorAlcool,valorGasolina)
                if (resultado < 0.7){
                    txtResultado.text = "Alcool é a melhor opção \nValor do Alcool = R$$valorAlcool\nValor da Gasolina: R$$valorGasolina"
                }else{
                    txtResultado.text = "Gasolina é a melhor opção \nValor do Alcool = R$$valorAlcool\nValor da Gasolina: R$$valorGasolina"
                }
            }
        }
    }
    private fun calculoAlcoolGasolina(alcool:Double, gasolina:Double):Double{
        return alcool/gasolina
    }
}