package br.com.merdado.livre.domain.di

import androidx.annotation.Keep
import br.com.merdado.livre.domain.usecase.CategoryKeyUseCase
import br.com.merdado.livre.domain.usecase.CategoryUseCase
import br.com.merdado.livre.domain.usecase.SiteUseCase
import org.koin.dsl.module

@Keep
object DomainModule {

    private val domain = module{

        factory { SiteUseCase(get()) }
        factory { CategoryUseCase(get()) }
        factory { CategoryKeyUseCase(get()) }
    }

    fun loadDomainModule() = domain

}