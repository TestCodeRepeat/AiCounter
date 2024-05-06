package com.flyingobjex.aicounter

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import com.flyingobjex.aicounter.ui.theme.AiCounterTheme
import com.flyingobjex.shared.presentation.AiCounterAction
import com.flyingobjex.shared.presentation.AiCounterAction.PostMessage
import com.flyingobjex.shared.presentation.AiCounterAction.Increment
import com.flyingobjex.shared.presentation.AiCounterState
import com.flyingobjex.shared.presentation.AiCounterStore


class MainActivity : ComponentActivity() {

    val store = AiCounterStore()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {

            val state = store.observeState().collectAsState()

            AiCounterTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    RootContentView(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding),
                        state = state.value,
                        dispatch = store::dispatch,
                    )
                }
            }
        }
    }
}

@Composable
fun RootContentView(
    name: String,
    modifier: Modifier = Modifier,
    state: AiCounterState,
    dispatch: (AiCounterAction) -> Unit,
) {
    Column(modifier = Modifier) {
        Text(
            text = "Hello there $name!",
            modifier = modifier
        )
        Text(text = "Shared messageState.value ==> ${state.message}")
        Text(text = "Shared counterState.value ==> ${state.count}")

        Button(onClick = {
            dispatch(Increment)
        }) {
            Text(text = "Increment")
        }

        Button(onClick = {
            dispatch(PostMessage("Post Message Clicked"))
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
