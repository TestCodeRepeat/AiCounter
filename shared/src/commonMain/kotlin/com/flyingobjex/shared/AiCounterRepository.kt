package com.flyingobjex.shared

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class AiCounterRepository {

    init {
        println("Shared ==> AiCounterRepository init")
    }

    private val _messageFlow = MutableStateFlow("Hello from shared module AGAIN!!")
    val messageFlow: StateFlow<String> = _messageFlow

    private val _counter = MutableStateFlow(0)
    val counter: StateFlow<Int> = _counter

    fun hello(): String {
        println("hello")
        println("Shared ==> 0000 counter.value =  ${counter.value}")
        val message = "Hello from shared module AGAIN!!" + " "  + counter.value
        _messageFlow.value = message
        val newValue = counter.value + 1
        _counter.value = newValue
        println("Shared ==> 1111 newValue =  ${newValue}")
        return message
    }
}