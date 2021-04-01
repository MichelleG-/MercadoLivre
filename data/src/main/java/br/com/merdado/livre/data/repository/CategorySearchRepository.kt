package br.com.merdado.livre.data.repository

import br.com.merdado.livre.data.remote.api.CategorySearchApi

class CategorySearchRepository(private val api: CategorySearchApi) {

    suspend fun getCategorySearch(site: String, limit : Int , text : String) = api.getDiscoverySearch(site, limit, text)
}