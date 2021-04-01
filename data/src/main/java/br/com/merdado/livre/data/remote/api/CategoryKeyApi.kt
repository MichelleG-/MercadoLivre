package br.com.merdado.livre.data.remote.api

import br.com.merdado.livre.data.remote.models.CategoryKey
import retrofit2.http.GET
import retrofit2.http.Path

interface CategoryKeyApi {

    @GET("categories/{id}}")
    suspend fun getCategoryKey(@Path("id") id : String) :CategoryKey
}