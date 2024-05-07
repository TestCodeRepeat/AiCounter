package com.flyingobjex.aicounter

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier

sealed class Screen {
    data object Counter : Screen()
    data object Todo : Screen()
}

@Composable
fun RootContentView(
    modifier: Modifier = Modifier,
    rootStore: RootStore,
) {

    val currentScreen by remember {
        mutableStateOf<Screen>(Screen.Counter)
    }

    when (currentScreen) {
        Screen.Counter -> CounterScreen(
            modifier = modifier,
            state = rootStore.counterStore.observeState().collectAsState().value,
            dispatch = rootStore.counterStore::dispatch,
        )

        Screen.Todo -> Text("TodoScreen")
    }


}

