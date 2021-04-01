package br.com.merdado.livre.data.remote.api

import br.com.merdado.livre.data.remote.models.Site
import retrofit2.http.GET

interface SiteApi {

    @GET("sites")
    suspend fun getSite() :List<Site>

}