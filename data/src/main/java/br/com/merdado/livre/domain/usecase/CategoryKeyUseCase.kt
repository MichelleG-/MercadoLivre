package br.com.merdado.livre.domain.usecase

import br.com.merdado.livre.data.remote.SafeResponse
import br.com.merdado.livre.data.remote.models.CategoryKey
import br.com.merdado.livre.data.remote.safeRequest
import br.com.merdado.livre.data.repository.CategoryKeyRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext

class CategoryKeyUseCase(
    private val repository: CategoryKeyRepository,
    dispatcher: CoroutineContext = Dispatchers.IO + SupervisorJob()
) {

    private var coroutinesScope = CoroutineScope(dispatcher)


    fun getCategoryKey(
        id: String,
        callback: (code: Boolean, data: CategoryKey?) -> Unit
    ) {

        coroutinesScope.launch {

            when (val response = safeRequest {
                repository.getCategoryKey(id)

            }) {

                is SafeResponse.Success -> callback(true, response.value)
                is SafeResponse.GenericError -> callback(false, null)
                is SafeResponse.NetworkError -> callback(false, null)
            }
        }
    }

}