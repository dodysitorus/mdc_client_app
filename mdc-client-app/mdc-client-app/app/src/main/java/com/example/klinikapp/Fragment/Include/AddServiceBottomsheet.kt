package com.example.klinikapp.Fragment.Include

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.klinikapp.R
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import kotlinx.android.synthetic.main.toolbar.*


class AddServiceBottomsheet : BottomSheetDialogFragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_add_service_bottomsheet, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        listener()
        setupToolbar()
    }

    private fun setupToolbar() {
        toolbar.title = "Tambah Layanan"
    }

    private fun listener() {

    }

    companion object{
        @JvmStatic
        fun newInstance(bundle: Bundle): AddServiceBottomsheet {
            val fragment = AddServiceBottomsheet()
            fragment.arguments = bundle
            return fragment
        }
    }

}