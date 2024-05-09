package com.flyingobjex.aicounter

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import com.flyingobjex.aicounter.ui.theme.AiCounterTheme
import com.flyingobjex.shared.domain.event.EventBusImpl
import com.flyingobjex.shared.domain.event.getFilteredEvents
import com.flyingobjex.shared.presentation.aicounter.AiCounterStore
import com.flyingobjex.shared.presentation.aitodo.AiTodoStore
import com.flyingobjex.shared.presentation.event.Event
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.launch

data class RootStore(
    val counterStore: AiCounterStore,
    val todoStore: AiTodoStore,
)

class MainActivity : ComponentActivity(), CoroutineScope by MainScope() {

    private val eventBus = EventBusImpl()
    private val rootStore = RootStore(
        counterStore = AiCounterStore(eventBus),
        todoStore = AiTodoStore(eventBus),
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        launch {
            eventBus.getFilteredEvents<Event.ToastEvent>().collect { event ->
                println("MainActivity.kt -- eventBus.getFilteredEvents<Event.ToastEvent>) ${event.message}")
            }
        }

        launch {
            eventBus.getFilteredEvents<Event.StoreSideEffect>().collect { event ->
                println("MainActivity.kt -- eventBus.getFilteredEvents<Event.ToastEvent>) ${event.action::class.simpleName}")
            }
        }

        enableEdgeToEdge()
        setContent {

            AiCounterTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    RootContentView(
                        modifier = Modifier.padding(innerPadding),
                        rootStore = rootStore,
                    )
                }
            }
        }
    }
}

