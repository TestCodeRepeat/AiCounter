package com.flyingobjex.aicounter

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.flyingobjex.shared.presentation.aicounter.AiCounterAction
import com.flyingobjex.shared.presentation.aicounter.AiCounterState

@Composable
fun CounterScreen(
    state: AiCounterState,
    dispatch: (AiCounterAction) -> Unit,
    modifier: Modifier,
) {
    Column(modifier = modifier) {
        Text(text = "Shared messageState.value ==> ${state.message}")
        Text(text = "Shared counterState.value ==> ${state.count}")

        Button(onClick = {
            dispatch(AiCounterAction.Increment)
        }) {
            Text(text = "Increment")
        }

        Button(onClick = {
            dispatch(AiCounterAction.PostMessage("Post Message Clicked"))
        }) {
            Text(text = "Post Message")
        }

        Button(onClick = {
            dispatch(AiCounterAction.IncrementWithOnComplete("Post Message Clicked") {
                println("onComplete -- navigationPlaceholder() ")
            })
        }) {
            Text(text = "Post Message")
        }
    }
}