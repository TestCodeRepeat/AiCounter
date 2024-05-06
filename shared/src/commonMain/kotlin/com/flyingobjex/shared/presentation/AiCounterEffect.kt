package com.flyingobjex.shared.presentation

sealed class AiCounterEffect : Effect {
    data class ShowToast(val message: String) : AiCounterEffect()
}