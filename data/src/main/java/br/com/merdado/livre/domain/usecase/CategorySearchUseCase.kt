package br.com.merdado.livre.domain.usecase

import br.com.merdado.livre.data.remote.SafeResponse
import br.com.merdado.livre.data.remote.models.Category
import br.com.merdado.livre.data.remote.models.CategorySearch
import br.com.merdado.livre.data.remote.safeRequest
import br.com.merdado.livre.data.repository.CategorySearchRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext

class CategorySearchUseCase(private val repository: CategorySearchRepository,
                            dispatcher: CoroutineContext = Dispatchers.IO + SupervisorJob()
) {


    private var coroutinesScope = CoroutineScope(dispatcher)


    fun getCategorySearch(site: String, limit : Int , text: String,
                          callback : (code : Boolean, data : List<CategorySearch>?) -> Unit
                          ) {

        coroutinesScope.launch {

            when(val response = safeRequest {
                repository.getCategorySearch(site, limit,text)

            }) {

                is SafeResponse.Success -> callback(true, response.value)
                is SafeResponse.GenericError -> callback(false , null)
                is SafeResponse.NetworkError -> callback(false , null)
            }
        }

    }
}