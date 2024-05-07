package com.flyingobjex.aicounter

import app.cash.turbine.FlowTurbine
import app.cash.turbine.test
import com.flyingobjex.shared.presentation.Action
import com.flyingobjex.shared.presentation.Effect
import com.flyingobjex.shared.presentation.State
import com.flyingobjex.shared.presentation.Store
import kotlin.time.Duration.Companion.milliseconds
import kotlinx.coroutines.test.runTest

suspend fun <S : State, A : Action, E : Effect> Store<S, A, E>.testState(test: suspend FlowTurbine<S>.() -> Unit) {
    observeState().test {
        runTest(timeout = 3000.milliseconds) {
            test()
        }
    }
}

suspend fun <S : State, A : Action, E : Effect> Store<S, A, E>.testSideEffect(test: suspend FlowTurbine<E>.() -> Unit) {
    observeSideEffects().test {
        runTest(timeout = 3000.milliseconds) {
            test()
        }
    }
}
