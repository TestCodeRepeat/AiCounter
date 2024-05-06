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
import com.flyingobjex.shared.AiCounterRepository


class MainActivity : ComponentActivity() {

    val repo = AiCounterRepository()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AiCounterTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding),
                        repo = repo
                    )
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier, repo: AiCounterRepository) {

    val counterState = repo.counter.collectAsState()
    val messageState = repo.messageFlow.collectAsState()

    Column(modifier = Modifier) {
        Text(
            text = "Hello there $name!",
            modifier = modifier
        )
        Text(text = "Shared messageState.value ==> ${messageState.value}")
        Text(text = "Shared counterState.value ==> ${counterState.value}")

        Button(onClick = { repo.hello() }) {
            println("onClick clicked")
            Text(text = "Increment")
        }
    }
}
