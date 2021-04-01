package br.com.merdado.livre.data.di

import androidx.annotation.Keep
import br.com.merdado.livre.data.remote.RetrofitServiceProvider
import br.com.merdado.livre.data.remote.api.CategoryApi
import br.com.merdado.livre.data.remote.api.CategoryKeyApi
import br.com.merdado.livre.data.remote.api.CategorySearchApi
import br.com.merdado.livre.data.remote.api.SiteApi
import br.com.merdado.livre.data.repository.CategoryRepository
import br.com.merdado.livre.data.repository.CategoryKeyRepository
import br.com.merdado.livre.data.repository.CategorySearchRepository
import br.com.merdado.livre.data.repository.SiteRepository
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module

@Keep
object DataModule {

    private val data = module {

        factory {
            RetrofitServiceProvider(androidApplication())
        }

        factory { get<RetrofitServiceProvider>().create(SiteApi::class.java) }
        factory { get<RetrofitServiceProvider>().create(CategoryApi::class.java) }
        factory { get<RetrofitServiceProvider>().create(CategoryKeyApi::class.java) }
        factory { get<RetrofitServiceProvider>().create(CategorySearchApi::class.java) }


        factory { SiteRepository(get()) }
        factory { CategoryRepository(get()) }
        factory { CategoryKeyRepository(get()) }
        factory { CategorySearchRepository(get()) }


    }

    fun loadDataModule() = data

}