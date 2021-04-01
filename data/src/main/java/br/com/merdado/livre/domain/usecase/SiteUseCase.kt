package br.com.merdado.livre.domain.usecase

import br.com.merdado.livre.data.remote.SafeResponse
import br.com.merdado.livre.data.remote.models.Site
import br.com.merdado.livre.data.remote.safeRequest
import br.com.merdado.livre.data.repository.SiteRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext

class SiteUseCase(private val repository: SiteRepository,
                  dispatcher: CoroutineContext = Dispatchers.IO + SupervisorJob()
) {

    private var coroutinesScope = CoroutineScope(dispatcher)


    fun getSite(callback : (code : Boolean, data : List<Site>?) -> Unit) {

        coroutinesScope.launch {

            when(val response = safeRequest {
                repository.getSite()

            }) {

                is SafeResponse.Success -> callback(true, response.value)
                is SafeResponse.GenericError -> callback(false , null)
                is SafeResponse.NetworkError -> callback(false , null)
            }
        }
    }
}