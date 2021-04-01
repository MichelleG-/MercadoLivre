package br.com.merdado.livre.data.remote.models

import android.os.Parcelable
import androidx.annotation.Keep
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Keep
@Parcelize
data class CategorySearch(

    @SerializedName("domain_id") val domainId : String? = "",
    @SerializedName("domain_name") val domainName : String? = "",
    @SerializedName("category_name") val categoryName: String? = "",
    @SerializedName("attributes") val attributes : List<Attributes>? = emptyList()


) : Parcelable


@Keep
@Parcelize
data class Attributes(
    @SerializedName("id") val id : String? = "",
    @SerializedName("name") val name : String? = "",
    @SerializedName("value_id") val valueId : String? = "",
    @SerializedName("value_name") val valueName : String = ""

) : Parcelable