package com.example.kmpdemo

import kotlin.random.Random

// MatrixUtils.kt
class MatrixUtils {
    fun matrixMultiplication(matrixA: List<List<Int>>, matrixB: List<List<Int>>): List<List<Int>> {
        val n = matrixA.size
        val resultMatrix = List(n) { MutableList(n) { 0 } }

        for (i in 0 until n) {
            for (j in 0 until n) {
                for (k in 0 until n) {
                    resultMatrix[i][j] += matrixA[i][k] * matrixB[k][j]
                }
            }
        }

        return resultMatrix
    }
}

class Greeting {
    private val platform: Platform = getPlatform()

    fun greet(): String {
        val matrixA = generateRandomMatrix(100)

        val matrixB = generateRandomMatrix(100)

        val matrixUtils = MatrixUtils()
        val resultMatrix = matrixUtils.matrixMultiplication(matrixA, matrixB)

        val greetingMessage = StringBuilder()
        for (row in resultMatrix) {
            for (element in row) {
                greetingMessage.append("$element ")
            }
            greetingMessage.appendLine()
        }

        return greetingMessage.toString()
    }
    private fun generateRandomMatrix(size: Int): List<List<Int>> {
        val random = Random
        return List(size) {
            List(size) { random.nextInt(100) }
        }
    }

}


