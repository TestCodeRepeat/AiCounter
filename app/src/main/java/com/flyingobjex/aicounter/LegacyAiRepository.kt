package com.flyingobjex.aicounter

class LegacyAiRepository {

    @Deprecated("to be replaced by :shared:domain:AiCounterRepository.hello()")
    fun hello(): String {
        val greeting = "AiCounterRepository.kt -- hello() counter.value ==> LEGACY"
        println(greeting)
        return greeting
    }
}