package com.example.androiddemo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.androiddemo.ui.theme.AndroidDemoTheme
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AndroidDemoTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {

                    CountingScreen()


                }
            }
        }
    }
}

@Composable
fun CountingScreen() {
    val startTime = System.currentTimeMillis()
    // State to control the button enabled/disabled state
    var isRunning by remember { mutableStateOf(false) }

    // State to store the matrix multiplication result
    var resultMatrix by remember { mutableStateOf(emptyList<List<Int>>()) }

    Column {
        // Button to trigger the matrix multiplication and update the count
        Button(
            onClick = {
                // Disable the button while the matrix multiplication is running
                isRunning = true

                // Reset the resultMatrix before starting a new computation
                resultMatrix = emptyList()

                // Launch a coroutine to run the matrix multiplication
                CoroutineScope(Dispatchers.Default).launch {
                    // Perform matrix multiplication and store the result
                    resultMatrix = matrixMultiplication(100) // Replace 3 with the desired n value

                    // Enable the button after the matrix multiplication is finished
                    isRunning = false
                }
            },
            enabled = !isRunning // Disable the button while the matrix multiplication is running
        ) {
            Text(text = "Run Matrix Multiplication")
        }

        // Display the matrix multiplication result on the screen
        if (resultMatrix.isNotEmpty()) {
            Text("Matrix Multiplication Result:")
            val endTime = System.currentTimeMillis()
            val duration = endTime - startTime
            Text(duration.toString())
            for (row in resultMatrix) {
                Text(row.toString())
            }
        }
    }
}

// Function to perform n x n matrix multiplication with O(n^3) complexity
private fun matrixMultiplication(n: Int): List<List<Int>> {
    // Create two sample n x n matrices (replace with your actual matrices)
    val matrixA = List(n) { i ->
        List(n) { j ->
            // Filling matrixA with random values for demonstration purposes
            (i + j + 1) * 2
        }
    }
    val matrixB = List(n) { i ->
        List(n) { j ->
            // Filling matrixB with random values for demonstration purposes
            (i + j + 1) * 3
        }
    }

    // Initialize the result matrix with zeros
    val resultMatrix = List(n) { MutableList(n) { 0 } }

    // Perform matrix multiplication (O(n^3))
    for (i in 0 until n) {
        for (j in 0 until n) {
            for (k in 0 until n) {

                resultMatrix[i][j] += matrixA[i][k] * matrixB[k][j]
            }
        }
    }

    return resultMatrix
}


@Preview(showBackground = true)
@Composable
fun CountingScreenPreview() {
    AndroidDemoTheme {
        CountingScreen()
    }
}
