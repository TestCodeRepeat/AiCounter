package com.flyingobjex.shared.presentation

data class AiCounterState(val count: Int = 0) : State

sealed class AiCounterAction : Action {
    data object Increment : AiCounterAction()
}

sealed class AiCounterEffect : Effect {
    data class ShowToast(val message: String) : AiCounterEffect()
}


class AiCounterStore : Store<AiCounterState, AiCounterAction, AiCounterEffect>() {
    override fun initState(): AiCounterState {
        return AiCounterState(0)
    }

    override fun dispatch(action: AiCounterAction) {
        when (action) {
            is AiCounterAction.Increment -> {
                currentState = currentState.copy(count = currentState.count + 1)
                sideEffect(AiCounterEffect.ShowToast("Incremented"))
            }
        }
    }
}
