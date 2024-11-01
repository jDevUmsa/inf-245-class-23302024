package com.example.impositivo

import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.example.impositivo.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val edSalario: EditText = findViewById(R.id.edSalario)
        val btnRCIVA: Button = findViewById(R.id.btnRCIVA)
        val btnIVA: Button = findViewById(R.id.btnIVA)

        val tvResultado: TextView = findViewById(R.id.tvResultado)

        btnRCIVA.setOnClickListener{
            var sal = edSalario.text.toString().toInt()
            var salNeto = 0.0
            var afp = 0.0
            var rciva = 0.0

            val smv = 2500

            afp = sal * 0.1275

            salNeto = sal - afp

            if(salNeto > (4 * smv)){
                rciva = salNeto * 0.13
                tvResultado.text = "RCIVA -> $rciva Bs."
            } else {
                rciva = 0.0
                tvResultado.text = "RCIVA -> $rciva Bs."
            }
        }
    }
}