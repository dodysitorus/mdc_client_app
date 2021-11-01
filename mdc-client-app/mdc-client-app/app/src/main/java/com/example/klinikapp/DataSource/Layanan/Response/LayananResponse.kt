package com.example.klinikapp.DataSource.Layanan.Response

import android.os.Message
import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class LayananResponse(
    @SerializedName("success")
    var success:Boolean,
    @SerializedName("data")
    var data:ArrayList<LayananItem>,
    @SerializedName("message")
    var message: String
):Parcelable

@Parcelize
data class LayananItem(
    @SerializedName("id")
    var id:String,
    @SerializedName("nama")
    var nama : String,
    @SerializedName("harga")
    var harga : String
):Parcelable