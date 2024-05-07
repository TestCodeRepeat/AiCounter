package com.flyingobjex.shared.presentation.aicounter

import com.flyingobjex.shared.presentation.Effect

sealed class AiCounterEffect : Effect {
    data class ShowToast(val message: String) : AiCounterEffect()
}