package com.example.klinikapp.Fragment

import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.example.klinikapp.R
import kotlinx.android.synthetic.main.fragment_home.*
import java.net.URLEncoder
import android.widget.Toast
import com.example.klinikapp.Fragment.Include.SettingBottomSheet
import kotlinx.android.synthetic.main.fragment_home_data.*


class HomeFragment : Fragment(){
    lateinit var img_wa:ImageView
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View? {
        val view =  inflater.inflate(R.layout.fragment_home, container, false)

        img_wa = view.findViewById(R.id.img_wa)

        setUpSosmed()


        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupListener()
        setupSetting()
    }

    @SuppressLint("UseRequireInsteadOfGet")
    private fun setUpSosmed() {
        img_wa.setOnClickListener {
            val smsNumber = "+6281268896161" // E164 format without '+' sign

            val sendIntent = Intent(Intent.ACTION_SEND)
            sendIntent.type = "text/plain"
            sendIntent.putExtra(Intent.EXTRA_TEXT, "This is my text to send.")
            sendIntent.putExtra(
                "jid",
                "$smsNumber@s.whatsapp.net"
            ) //phone number without "+" prefix

            sendIntent.setPackage("com.whatsapp")
            if (sendIntent.resolveActivity(activity!!.packageManager) == null) {
                Toast.makeText(activity, "Error/n" + "error", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            startActivity(sendIntent)
        }
    }

    private fun setupListener(){
        img_btnComplete.setOnClickListener {
            val openURL = Intent(Intent.ACTION_VIEW)
            openURL.data = Uri.parse("https://www.medandentalcenter.com/blog")
            context?.startActivity(openURL)
        }

        card_content_1.setOnClickListener {
            val openURL = Intent(Intent.ACTION_VIEW)
            openURL.data = Uri.parse("https://www.medandentalcenter.com/gingivitis")
            context?.startActivity(openURL)
        }

        card_content_2.setOnClickListener {
            val openURL = Intent(Intent.ACTION_VIEW)
            openURL.data = Uri.parse("https://www.medandentalcenter.com/bleaching-gigi-di-medan-dental-center")
            context?.startActivity(openURL)
        }

        card_content_3.setOnClickListener {
            val openURL = Intent(Intent.ACTION_VIEW)
            openURL.data = Uri.parse("https://www.medandentalcenter.com/scaling-gigi-atau-pembersihan-karang-gigi")
            context?.startActivity(openURL)
        }

        card_content_4.setOnClickListener {
            val openURL = Intent(Intent.ACTION_VIEW)
            openURL.data = Uri.parse("https://www.medandentalcenter.com/pindah-kontrol-kawat-gigi-atau-behel")
            context?.startActivity(openURL)
        }
    }

    private fun setupSetting(){
        btn_Setting?.setOnClickListener {
            requireActivity().supportFragmentManager.let {
                SettingBottomSheet.newInstance(Bundle()).apply {
                    show(it, tag)
                }
            }
        }
    }
}