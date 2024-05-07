package com.flyingobjex.shared.di

import com.flyingobjex.shared.domain.AiCounterRepository
import org.koin.core.context.startKoin
import org.koin.dsl.KoinAppDeclaration
import org.koin.dsl.module


fun main() {
    startKoin {
        modules()
    }
}

fun initKoin(appDeclaration: KoinAppDeclaration = {}) =
    startKoin {
        modules(commonModule())
        appDeclaration()
    }

// called by iOS client
fun initKoin() = initKoin() {}

fun commonModule() = module {
    single { AiCounterRepository() }
}
//    includes(platformModule())
//
//    singleOf(::AiCounter)
//    singleOf(::AppSettings)
//    singleOf(::ApolloClientCache)
//
//    singleOf(::GeminiApi)
//}