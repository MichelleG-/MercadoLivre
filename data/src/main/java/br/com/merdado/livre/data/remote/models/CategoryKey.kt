package br.com.merdado.livre.data.remote.models

import android.os.Parcelable
import androidx.annotation.Keep
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Keep
@Parcelize
data class CategoryKey(

    @SerializedName("id") val id : String? = "",
    @SerializedName("name") val name: String? = "",
    @SerializedName("picture") val picture: String? = "",
    @SerializedName("permalink") val permalink : String? = "",
    @SerializedName("total_items_in_this_category") val totalItemsThisCategory : Long? = 0,
    @SerializedName("children_categories") val pathFromRoot: List<PathFromRoot> = emptyList()

    ) : Parcelable


@Keep
@Parcelize
data class PathFromRoot(
    @SerializedName("id") val id : String? ,
    @SerializedName("name") val name: String?

) :Parcelable