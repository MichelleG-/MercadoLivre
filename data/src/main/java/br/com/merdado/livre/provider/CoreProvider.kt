package br.com.merdado.livre.provider

import androidx.annotation.Keep
import br.com.merdado.livre.data.remote.models.Category
import br.com.merdado.livre.data.remote.models.CategoryKey
import br.com.merdado.livre.data.remote.models.CategorySearch
import br.com.merdado.livre.data.remote.models.Site
import br.com.merdado.livre.domain.usecase.CategoryKeyUseCase
import br.com.merdado.livre.domain.usecase.CategorySearchUseCase
import br.com.merdado.livre.domain.usecase.CategoryUseCase
import br.com.merdado.livre.domain.usecase.SiteUseCase
import br.com.merdado.livre.provider.di.CustomKoinComponent
import org.koin.android.ext.android.inject


@Keep
class CoreProvider : InitProvider(), CustomKoinComponent {

    private val categoryKeyUseCase by inject<CategoryKeyUseCase>()
    private val categorySearchUseCase by inject<CategorySearchUseCase>()
    private val categoryUseCase by inject<CategoryUseCase>()
    private val siteUseCase by inject<SiteUseCase>()


    fun getSite(
        callback: (success: Boolean, data : List<Site>?) -> Unit
    ) = siteUseCase.getSite(callback)

    fun getCategory(
        site: String,
        callback: (success: Boolean, data : List<Category>?) -> Unit
    ) = categoryUseCase.getCategories(site, callback)

    fun getCategoryKey(
        id: String,
        callBack: (success: Boolean, data: CategoryKey?) -> Unit
    ) = categoryKeyUseCase.getCategoryKey(id, callBack)

    fun getCategorySearch(
        site : String,
        limit : Int,
        text : String,
        callBack: (success: Boolean, data: List<CategorySearch>?) -> Unit
    ) = categorySearchUseCase.getCategorySearch(site, limit, text,callBack)
}