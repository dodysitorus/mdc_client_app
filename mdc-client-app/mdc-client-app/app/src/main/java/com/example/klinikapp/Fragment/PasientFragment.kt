package com.example.klinikapp.Fragment

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.klinikapp.Presentation.AddPatientActivity
import com.example.klinikapp.R
import kotlinx.android.synthetic.main.fragment_pasient.*
import kotlinx.android.synthetic.main.toolbar.*


class PasientFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View? {

        return inflater.inflate(R.layout.fragment_pasient, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        SetupToolbar()
        setUpListener()
        setupShimmer()
    }

    private fun setupShimmer() {
        shimmerLayout.startShimmerAnimation()
    }

    private fun SetupToolbar(){
        toolbar.setTitle("Data Pasien")
        toolbar.setTitleTextColor(Color.WHITE)
    }

    private fun setUpListener(){
        fab_add_patient.setOnClickListener {
            startActivity(Intent(activity, AddPatientActivity::class.java))
        }
    }
}