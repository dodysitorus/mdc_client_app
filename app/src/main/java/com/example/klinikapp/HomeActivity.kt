package com.example.klinikapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.klinikapp.Fragment.DoctorFragment
import com.example.klinikapp.Fragment.JadwalFragmet
import com.example.klinikapp.Fragment.PasientFragment
import com.example.klinikapp.Fragment.ServiceFragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.activity_home.*
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level
import com.example.klinikapp.Fragment.HomeFragment as HomeFragment1

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)



        loadFragment(HomeFragment1())
        setupView()
        setupBottomNav()
    }

    private fun loadFragment(fragment: Fragment) {
        var transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.main_container, fragment)
        transaction.commit()
    }

    private fun setupView(){

    }

    private fun setupBottomNav(){
        bottomNav.setOnNavigationItemSelectedListener {
            when(it.itemId){
                R.id.page_1 -> {
                    loadFragment(DoctorFragment())
                    bottomNav.menu.getItem(0).setCheckable(true)
                }
                R.id.page_2 -> {
                    loadFragment(PasientFragment())
                    bottomNav.menu.getItem(1).setCheckable(true)
                }
                R.id.page_3 -> {
                    loadFragment(JadwalFragmet())
                    bottomNav.menu.getItem(0).setCheckable(true)
                }
                R.id.page_4 -> {
                    loadFragment(ServiceFragment())
                    bottomNav.menu.getItem(0).setCheckable(true)
                }

            }
            true
        }
        bottomNav.menu.getItem(0).setCheckable(false)
        bottomNav.setSelectedItemId(R.id.invisible)

        home_btn.setOnClickListener {
            loadFragment(HomeFragment1())
            bottomNav.menu.getItem(0).setCheckable(false)
            bottomNav.menu.getItem(1).setCheckable(false)
            bottomNav.menu.getItem(2).setCheckable(false)
            bottomNav.menu.getItem(3).setCheckable(false)
        }
    }
}