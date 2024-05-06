package com.flyingobjex.shared.presentation

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.sync.Mutex
import kotlinx.coroutines.sync.withLock

interface State
interface Action
interface Effect

abstract class Store<S : State, A : Action, E : Effect>(
    private val coroutineScope: CoroutineScope = CoroutineScope(Dispatchers.Main),
) : CoroutineScope by coroutineScope {

    protected abstract fun initState(): S
    protected var state
        get() = _state.value
        set(value) {
            _state.value = value
        }

    private val _state = MutableStateFlow(initState())
    private val effects = MutableSharedFlow<E>()
    private val mutex: Mutex = Mutex()

    val iosState: StateFlow<S> = _state.asStateFlow()

    fun observeState(): StateFlow<S> = _state.asStateFlow()
    fun observeSideEffects(): Flow<E> = effects
    fun sideEffect(effect: E) = launch {
        effects.emit(effect)
    }

    protected fun updateState(newState: S) {
        state = newState
    }

    protected suspend fun updateState(block: (current: S) -> S) {
        mutex.withLock {
            _state.value = block(state)
        }
    }

    abstract fun dispatch(action: A)
}