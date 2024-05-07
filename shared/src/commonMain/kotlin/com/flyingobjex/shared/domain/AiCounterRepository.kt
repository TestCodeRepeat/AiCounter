package com.flyingobjex.shared.domain

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class AiCounterRepository {

    init {
        println("Shared ==> AiCounterRepository init")
    }

    private val _counter = MutableStateFlow(0)
    val counter: StateFlow<Int> = _counter

    fun hello(): String {
        val greeting = "AiCounterRepository.kt -- hello() counter.value ==> ${counter.value}"
        println(greeting)
        val newValue = counter.value + 1
        _counter.value = newValue
        return greeting
    }
}