package br.com.merdado.livre.data.remote.api

import br.com.merdado.livre.data.remote.models.Category
import retrofit2.http.GET
import retrofit2.http.Path

interface CategoryApi {

    @GET("sites/{site}/categories")
    suspend fun getCategories(@Path("site") site : String) : List<Category>

}