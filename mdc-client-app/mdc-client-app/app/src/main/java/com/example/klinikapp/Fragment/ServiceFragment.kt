package com.example.klinikapp.Fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.klinikapp.Adapter.ServiceAdapter
import com.example.klinikapp.DataSource.Layanan.Module.injectFeature
import com.example.klinikapp.DataSource.Layanan.Resource.Resource
import com.example.klinikapp.DataSource.Layanan.Resource.ResourceState
import com.example.klinikapp.DataSource.Layanan.Response.LayananResponse
import com.example.klinikapp.DataSource.Layanan.ViewModel.LayananViewModel
import com.example.klinikapp.Fragment.Include.AddServiceBottomsheet
import com.example.klinikapp.R
import kotlinx.android.synthetic.main.fragment_doctor.*
import kotlinx.android.synthetic.main.fragment_service.*
import kotlinx.android.synthetic.main.fragment_service.shimmerLayout
import kotlinx.android.synthetic.main.toolbar.*
import org.koin.androidx.viewmodel.ext.viewModel


class ServiceFragment : Fragment() {

    val vm : LayananViewModel by viewModel()
    private val serviceAdapter = ServiceAdapter()

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
        setUpListView()
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
                    shimmerLayout.visibility = View.VISIBLE
                    shimmerLayout.startShimmerAnimation()
                }
                ResourceState.SUCCESS ->{
                    shimmerLayout.visibility = View.GONE
                    rv_service.visibility = View.VISIBLE
                    it.data.let {
                        it?.data?.let{
                            if(data == null){
                                ll_noData.visibility = View.VISIBLE
                                rv_service.visibility = View.GONE
                            }else{
                                serviceAdapter.setData(it)
                            }
                        }
                    }
                }
                else -> {
                    shimmerLayout.visibility=View.GONE
                    rv_service.visibility = View.GONE
                    ll_errorData.visibility = View.VISIBLE
                }
            }
        }
    }
    private fun setUpListView() {
        rv_service.adapter = serviceAdapter
        rv_service.layoutManager = LinearLayoutManager(requireActivity())
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