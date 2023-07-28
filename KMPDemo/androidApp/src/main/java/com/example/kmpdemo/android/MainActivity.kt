package com.example.kmpdemo.android

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.kmpdemo.Greeting

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApplicationTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
//                    GreetingView(Greeting().greet())
                    GreetingScreen()
                }
            }
        }
    }
}

@Composable
fun GreetingScreen() {
    val startTime = System.currentTimeMillis()
    val greetingText = remember { mutableStateOf("") }

    Column {
        Button(
            onClick = {
                greetingText.value = Greeting().greet()
            },

        ) {
            Text(text = "Call Greeting")
        }
        val endTime = System.currentTimeMillis()
        val duration = endTime - startTime
        Text(duration.toString())

        GreetingView(text = greetingText.value)
    }
}


@Composable
fun GreetingView(text: String) {
    Text(text = text)
}

@Preview
@Composable
fun DefaultPreview() {
    MyApplicationTheme {
        GreetingView("Hello, Android!")
    }
}
