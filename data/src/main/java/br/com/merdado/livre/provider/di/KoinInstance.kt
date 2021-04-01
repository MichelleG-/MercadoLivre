package br.com.merdado.livre.provider.di

import org.koin.core.KoinApplication

class KoinInstance {
    object KoinContext {
        lateinit var koinApplication: KoinApplication
    }
}