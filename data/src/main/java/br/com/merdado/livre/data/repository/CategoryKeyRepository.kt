package br.com.merdado.livre.data.repository

import br.com.merdado.livre.data.remote.api.CategoryKeyApi

class CategoryKeyRepository(private val api: CategoryKeyApi) {

    suspend fun getCategoryKey(id : String) = api.getCategoryKey(id)
}