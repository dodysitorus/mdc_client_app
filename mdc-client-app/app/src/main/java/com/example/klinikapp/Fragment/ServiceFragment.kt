package com.example.klinikapp.Fragment

import android.app.ProgressDialog.show
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import com.example.klinikapp.DataSource.Layanan.Module.injectFeature
import com.example.klinikapp.DataSource.Layanan.Resource.Resource
import com.example.klinikapp.DataSource.Layanan.Resource.ResourceState
import com.example.klinikapp.DataSource.Layanan.Response.LayananResponse
import com.example.klinikapp.DataSource.Layanan.ViewModel.LayananViewModel
import com.example.klinikapp.Fragment.Include.AddServiceBottomsheet
import com.example.klinikapp.Fragment.Include.SettingBottomSheet
import com.example.klinikapp.R
import kotlinx.android.synthetic.main.fragment_home.*
import kotlinx.android.synthetic.main.fragment_service.*
import kotlinx.android.synthetic.main.toolbar.*
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.ext.viewModel
import org.koin.core.context.startKoin


class ServiceFragment : Fragment() {

    val vm : LayananViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_service, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        injectFeature()
        setupToolbar()
        Observe()
        loadData()
        listener()
    }

    private fun setupToolbar(){
        toolbar.title = "Layanan"


    }

    private fun Observe(){
        vm.showLayanan.observe(requireActivity(), Observer { setupAdapter(it) })
    }

    private fun setupAdapter(data: Resource<LayananResponse>?) {
        data?.let {
            when(it.state){
                ResourceState.LOADING->{
                    shimmerLayout.startShimmerAnimation()
                }
                ResourceState.SUCCESS ->{
                    shimmerLayout.visibility = View.GONE
                    recyclerView.visibility = View.VISIBLE
                    it.data.let {
                        it?.data?.let{
                            Log.d("Data : ", data.data.toString())
                        }
                    }
                }
                else -> {

                }
            }
        }
    }

    private fun loadData(){
        vm.showLayanan()
    }

    private fun listener(){
        fab_add_service.setOnClickListener {
            requireActivity().supportFragmentManager.let {
                AddServiceBottomsheet.newInstance(Bundle()).apply {
                    show(it, tag)
                }
            }
        }
    }
}