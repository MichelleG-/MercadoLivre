package br.com.merdado.livre.data.remote.api

import br.com.merdado.livre.data.remote.models.CategorySearch
import retrofit2.http.GET
import retrofit2.http.Path

interface CategorySearchApi {

    @GET("sites/{site}/domain_discovery/search?limit={limit}&q={value}")
    suspend fun getDiscoverySearch(@Path("site") site : String ,
                                   @Path("limit")
                                   limit: Int , @Path("value") value : String ) : List<CategorySearch>
}