package com.flyingobjex.shared.presentation.aicounter

import com.flyingobjex.shared.presentation.Action

sealed class AiCounterAction : Action {
    data object Increment : AiCounterAction()
    data class PostMessage(val message: String) : AiCounterAction()
    data class IncrementWithOnComplete(val message: String, val onComplete: () -> Unit) : AiCounterAction()
    data class SearchWeb(val searchTerm: String) : AiCounterAction()
}