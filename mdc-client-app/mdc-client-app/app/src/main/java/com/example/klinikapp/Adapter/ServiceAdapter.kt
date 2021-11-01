package com.example.klinikapp.Adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.klinikapp.DataSource.Layanan.Response.LayananItem
import com.example.klinikapp.DataSource.inflate
import com.example.klinikapp.R
import kotlinx.android.synthetic.main.service_item.view.*

class ServiceAdapter : RecyclerView.Adapter<ServiceAdapter.ViewHolderItem>() {


    private val items by lazy { mutableListOf<LayananItem>() }

    fun setData(data: List<LayananItem>) {
        items.clear()
        items.addAll(data)
        notifyDataSetChanged()
    }

    class ViewHolderItem(parent: ViewGroup, serviceItem: Int):
    RecyclerView.ViewHolder(parent.inflate(serviceItem)){
        fun bind(layananResponse: LayananItem) {
            itemView.tv_no.text = layananResponse.id
            itemView.tv_name.text = layananResponse.nama
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderItem {
        return ViewHolderItem(parent, R.layout.service_item)
    }

    override fun onBindViewHolder(holder: ViewHolderItem, position: Int) {
        return holder.bind(items[position])
    }

    override fun getItemCount(): Int {
        return items.size
    }
}