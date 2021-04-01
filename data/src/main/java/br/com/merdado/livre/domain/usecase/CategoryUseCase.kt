package br.com.merdado.livre.domain.usecase

import br.com.merdado.livre.data.remote.SafeResponse
import br.com.merdado.livre.data.remote.models.Category
import br.com.merdado.livre.data.remote.safeRequest
import br.com.merdado.livre.data.repository.CategoryRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext

class CategoryUseCase(private val repository: CategoryRepository,
                      dispatcher: CoroutineContext = Dispatchers.IO + SupervisorJob()
) {

    private var coroutinesScope = CoroutineScope(dispatcher)


    fun getCategories(site : String,
                      callback : (code : Boolean, data : List<Category>?) -> Unit)
                       {

        coroutinesScope.launch {

            when(val response = safeRequest {
                repository.getCategories(site)

            }) {

                is SafeResponse.Success -> callback(true, response.value)
                is SafeResponse.GenericError -> callback(false , null)
                is SafeResponse.NetworkError -> callback(false , null)
            }
        }
    }
}