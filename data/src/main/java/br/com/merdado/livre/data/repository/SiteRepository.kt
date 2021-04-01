package br.com.merdado.livre.data.repository

import br.com.merdado.livre.data.remote.api.SiteApi

class SiteRepository(private val api: SiteApi) {

    suspend fun getSite() = api.getSite()
}