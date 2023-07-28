//
//  matrixmult.swift
//  iOSDemo
//
//  Created by Harshita Kalani on 26/07/23.
//

import Foundation

struct MatrixUtils {
    static func matrixMultiplication(_ matrixA: [[Int]], _ matrixB: [[Int]]) -> [[Int]] {
        let n = matrixA.count
        var resultMatrix = Array(repeating: Array(repeating: 0, count: n), count: n)

        for i in 0..<n {
            for j in 0..<n {
                for k in 0..<n {
                    resultMatrix[i][j] += matrixA[i][k] * matrixB[k][j]
                }
            }
        }

        return resultMatrix
    }
}
