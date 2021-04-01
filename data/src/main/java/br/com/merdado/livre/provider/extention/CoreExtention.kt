package br.com.merdado.livre.provider.extention

import br.com.merdado.livre.data.di.DataModule
import br.com.merdado.livre.domain.di.DomainModule
import br.com.merdado.livre.provider.InitProvider
import br.com.merdado.livre.provider.di.KoinInstance
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.koinApplication

fun InitProvider.startKoinCore() {
    KoinInstance.KoinContext.koinApplication = koinApplication {
        androidContext(getAppContext())
        val listModules = listOf(DataModule.loadDataModule() , DomainModule.loadDomainModule())
        modules(listModules)
    }
}