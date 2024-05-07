package com.flyingobjex.aicounter

import com.flyingobjex.shared.domain.event.EventBusImpl
import com.flyingobjex.shared.presentation.aicounter.AiCounterAction
import com.flyingobjex.shared.presentation.aicounter.AiCounterStore
import kotlin.test.assertEquals
import kotlinx.coroutines.test.runTest
import org.junit.Test

class AiCounterStoreTest {

    private val eventBus = EventBusImpl()
    private val underTest = AiCounterStore(eventBus)

    @Test
    fun shouldIncrementInitialState() = runTest {
        underTest.testState {
            with(awaitItem()) {
                assertEquals(expected = 0, actual = count)
            }
        }
        underTest.dispatch(AiCounterAction.Increment)
        underTest.testState {
            with(awaitItem()) {
                assertEquals(expected = 1, actual = count)
            }
        }

    }
}