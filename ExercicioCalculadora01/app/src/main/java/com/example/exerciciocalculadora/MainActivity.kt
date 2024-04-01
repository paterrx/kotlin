package com.example.exerciciocalculadora

import android.os.Bundle
import android.provider.Settings.Panel
import android.widget.TextView
import android.widget.Button
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val btn1 = findViewById<Button>(R.id.btn1)
        val btn2 = findViewById<Button>(R.id.btn2)
        val btn3 = findViewById<Button>(R.id.btn3)
        val btn4 = findViewById<Button>(R.id.btn4)
        val btn5 = findViewById<Button>(R.id.btn5)
        val btn6 = findViewById<Button>(R.id.btn6)
        val btn7 = findViewById<Button>(R.id.btn7)
        val btn8 = findViewById<Button>(R.id.btn8)
        val btn9 = findViewById<Button>(R.id.btn9)
        val btn0 = findViewById<Button>(R.id.btn0)
        val btnDivisao = findViewById<Button>(R.id.btnDivisao)
        val btnMultiplicacao = findViewById<Button>(R.id.btnMultiplicacao)
        val btnMais = findViewById<Button>(R.id.btnMais)
        val btnMenos = findViewById<Button>(R.id.btnMenos)
        val btnClear = findViewById<Button>(R.id.btnClear)
        val btnResultado = findViewById<Button>(R.id.btnResultado)

        val txtPanel = findViewById<TextView>(R.id.txtVisor)

        btn1.setOnClickListener { addPainel(txtPanel, "1")}
        btn2.setOnClickListener { addPainel(txtPanel, "2")}
        btn3.setOnClickListener { addPainel(txtPanel, "3")}
        btn4.setOnClickListener { addPainel(txtPanel, "4")}
        btn5.setOnClickListener { addPainel(txtPanel, "5")}
        btn6.setOnClickListener { addPainel(txtPanel, "6")}
        btn7.setOnClickListener { addPainel(txtPanel, "7")}
        btn8.setOnClickListener { addPainel(txtPanel, "8")}
        btn9.setOnClickListener { addPainel(txtPanel, "9")}
        btn0.setOnClickListener { addPainel(txtPanel, "0")}
        btnDivisao.setOnClickListener { addPainel(txtPanel, "÷")}
        btnMultiplicacao.setOnClickListener { addPainel(txtPanel, "X")}
        btnMais.setOnClickListener { addPainel(txtPanel, "+")}
        btnMenos.setOnClickListener { addPainel(txtPanel, "-")}

        btnClear.setOnClickListener{txtPanel.text = ""}

        btnResultado.setOnClickListener{
            val panelValue = txtPanel.text

            when{
               panelValue.contains("-") -> menos(panelValue, txtPanel)
                panelValue.contains("+") -> somar(panelValue, txtPanel)
                panelValue.contains("X") -> multiplicar(panelValue, txtPanel)
                panelValue.contains("÷") -> dividir(panelValue, txtPanel)
            }
        }


    }

    private fun dividir(panelValue: CharSequence, txtPanel: TextView){
        val aux = panelValue.split("÷")
        var result = 0
        for (item in aux) {
            item.toIntOrNull()?.let {
                if(result==0){
                    result = it
                }
                else {
                    result / it
                    txtPanel.text= result.toString()
                }
            } ?: run {
                Toast.makeText(
                    this,
                    "ERRO AO EXECUTAR O CALCULO, TENTE NOVAMENTE !",
                    Toast.LENGTH_LONG
                ).show()
                txtPanel.text=""
            }
        }
    }
    private fun multiplicar(panelValue: CharSequence, txtPanel: TextView){
        val aux = panelValue.split("X")
        var result = 0
        for (item in aux) {
            item.toIntOrNull()?.let {
                if(result==0){
                    result = it
                }
                else {
                    result *= it
                    txtPanel.text= result.toString()
                }
            } ?: run {
                Toast.makeText(
                    this,
                    "ERRO AO EXECUTAR O CALCULO, TENTE NOVAMENTE !",
                    Toast.LENGTH_LONG
                ).show()
                txtPanel.text=""
            }
        }
    }
    private fun somar(panelValue: CharSequence, txtPanel: TextView){
        val aux = panelValue.split("+")
        var result = 0
        for (item in aux) {
            item.toIntOrNull()?.let {
                    result += it
                    txtPanel.text= result.toString()
            } ?: run {
                Toast.makeText(
                    this,
                    "ERRO AO EXECUTAR O CALCULO, TENTE NOVAMENTE !",
                    Toast.LENGTH_LONG
                ).show()
                txtPanel.text=""
            }
        }
    }
    private fun menos(panelValue: CharSequence, txtPanel: TextView){
        val aux = panelValue.split("-")
        var result = 0
        for (item in aux) {
            item.toIntOrNull()?.let {
                if(result==0){
                    result = it
                }
                else {
                    result -= it
                    txtPanel.text= result.toString()
                }
            } ?: run {
                Toast.makeText(
                    this,
                    "ERRO AO EXECUTAR O CALCULO, TENTE NOVAMENTE !",
                    Toast.LENGTH_LONG
                ).show()
                txtPanel.text=""
            }
        }
    }

    private fun addPainel(txtPanel: TextView, value: String) {
        txtPanel.text = "${txtPanel.text}$value"
    }
}