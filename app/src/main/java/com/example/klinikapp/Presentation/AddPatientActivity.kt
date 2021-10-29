package com.example.klinikapp.Presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.klinikapp.R
import kotlinx.android.synthetic.main.toolbar.*

class AddPatientActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_patient)

        setUpToolbar()
    }

    private fun setUpToolbar(){
        toolbar.setTitle("Tambah Data Pasien")
        setSupportActionBar(toolbar)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        toolbar.setNavigationIcon(R.drawable.ic_baseline_arrow_back_24)
        toolbar.setNavigationOnClickListener {
            onBackPressed()
        }
    }
}