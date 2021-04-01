package br.com.merdado.livre.data.repository

import br.com.merdado.livre.data.remote.api.CategoryApi

class CategoryRepository(private val api: CategoryApi) {

    suspend fun getCategories(site : String) = api.getCategories(site)
}