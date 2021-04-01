package br.com.merdado.livre.data.remote.models

import android.os.Parcelable
import androidx.annotation.Keep
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Keep
@Parcelize
data class Category(
    @SerializedName("id") val id : String? = "",
    @SerializedName("name") val name: String? = ""
) : Parcelable
