package com.gstechnology.calculadoraimc

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {

    private lateinit var btnCalcular: Button
    private lateinit var editPeso: EditText
    private lateinit var editAltura: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnCalcular = findViewById( R.id.btn_calcular )
        editPeso = findViewById( R.id.edit_peso )
        editAltura = findViewById( R.id.edit_altura )

        btnCalcular.setOnClickListener {

            val intent = Intent(this, ResultadoActivity::class.java)


            val peso = editPeso.text.toString()
            val altura = editAltura.text.toString()

            if ( peso.isNotEmpty() && altura.isNotEmpty() ) {

                intent.putExtra( "peso", peso.toDouble() )
                intent.putExtra( "altura", altura.toDouble() )

            }

            val resultadoValidacao = validarCampos(peso, altura)

            if ( resultadoValidacao ) {

                startActivity(intent)
                editAltura.setText("")
                editPeso.setText("")

            }


        }

    }

    private fun validarCampos(peso: String, altura: String): Boolean {

        editPeso.error = null
        editAltura.error = null

        if ( peso.isEmpty() ) {

            editPeso.error = "Digite um valor válido"
            return false

        } else if ( altura.isEmpty() ) {

            editAltura.error = "Digite um valor válido"
            return false

        } else {

            return true

        }

    }

}