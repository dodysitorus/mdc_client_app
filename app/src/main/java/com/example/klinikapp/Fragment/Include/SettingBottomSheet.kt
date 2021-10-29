package com.example.klinikapp.Fragment.Include

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.klinikapp.LoginActivity
import com.example.klinikapp.R
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import kotlinx.android.synthetic.main.fragment_setting_bottom_sheet.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class SettingBottomSheet : BottomSheetDialogFragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_setting_bottom_sheet, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setUpViews()

    }

    private fun setUpViews(){
        txt_modeTerang.setOnClickListener {

        }

        txt_modeGelap.setOnClickListener {

        }

        txt_logout.setOnClickListener {
            requireActivity().startActivity(Intent(activity, LoginActivity::class.java))
        }
    }

//    private var mListener: ItemClickListener? = null
//
//    override fun onAttach(context: Context) {
//        super.onAttach(context)
//        if (context is ItemClickListener) {
//            mListener = context as ItemClickListener
//        } else {
//            throw RuntimeException(
//                context.toString()
//                    .toString() + " must implement ItemClickListener"
//            )
//        }
//    }
//
//    override fun onDetach() {
//        super.onDetach()
//        mListener = null
//    }
//    interface ItemClickListener {
//        fun onItemClick(item: String)
//    }


    companion object {
        @JvmStatic
        fun newInstance(bundle: Bundle): SettingBottomSheet {
            val fragment = SettingBottomSheet()
            fragment.arguments = bundle
            return fragment
        }
    }
}