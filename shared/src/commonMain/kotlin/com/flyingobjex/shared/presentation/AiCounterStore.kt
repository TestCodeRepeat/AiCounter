package com.flyingobjex.shared.presentation

import com.flyingobjex.shared.AiCounterRepository
import kotlinx.coroutines.launch

data class AiCounterState(val count: Int = 0, val message: String) : State

class AiCounterStore : Store<AiCounterState, AiCounterAction, AiCounterEffect>() {

    val repo = AiCounterRepository()

    override fun initState(): AiCounterState {
        return AiCounterState(0, "--")
    }

    override fun dispatch(action: AiCounterAction) {
        println("AiCounterStore.kt -- dispatch() ==> $action")
        when (action) {
            is AiCounterAction.Increment -> increment()
            is AiCounterAction.IncrementWithOnComplete -> increment(action)
            is AiCounterAction.PostMessage -> postMessage(action)
            is AiCounterAction.SearchWeb -> searchWeb(action)
        }
    }

    private fun searchWeb(action: AiCounterAction.SearchWeb) {


    }

    private suspend fun incrementAsync(action: AiCounterAction.IncrementWithOnComplete) {
        launch {

            updateState(state.copy(count = state.count + 1))
            action.onComplete()
        }
    }

    private fun increment(action: AiCounterAction.IncrementWithOnComplete) {
        updateState(state.copy(count = state.count + 1))
        action.onComplete()
    }

    private fun increment() {
        println("AiCounterStore.kt -- handleIncrement() ==> ")
        updateState(state.copy(count = state.count + 1))
        sideEffect(AiCounterEffect.ShowToast("Incremented"))
    }

    private fun postMessage(action: AiCounterAction.PostMessage) {
        println("AiCounterStore.kt -- postMessage() ==> $${action.message}")
        sideEffect(AiCounterEffect.ShowToast(action.message))
        updateState(state.copy(message = action.message))
    }
}
