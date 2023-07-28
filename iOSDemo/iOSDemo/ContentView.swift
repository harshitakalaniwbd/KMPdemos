//
//  ContentView.swift
//  iOSDemo
//
//  Created by Harshita Kalani on 24/07/23.
//
import SwiftUI

//struct ContentView: View {
//    @State private var count: Int = 0
//    @State private var isRunning: Bool = false
//
//    var body: some View {
//        VStack {
//
//            Text("Count: \(count)")
//                .font(.title)
//
//            Button(action: {
//                runLoop()
//            }) {
//                Text(isRunning ? "Running..." : "Run For Loop")
//                    .padding()
//            }
//            .buttonStyle(SquareButtonStyle())
//            .disabled(isRunning)
//        }
//        .padding()
//    }
//
//    func runLoop() {
//        isRunning = true
//        for i in 0..<1000 {
//            DispatchQueue.main.asyncAfter(deadline: .now() + Double(i) * 0.1) {
//                count = i + 1
////                sleep(1)
//                if i == 999 {
//                    isRunning = false
//                    count = 0
//                }
//            }
//        }
//    }
//}
struct ContentView: View {
    @State private var resultMatrix: [[Int]] = []
    @State private var isRunning: Bool = false

    var body: some View {
        VStack {
            // Display the result matrix (if available)
            if !resultMatrix.isEmpty {
                ForEach(resultMatrix, id: \.self) { row in
                    Text(row.map { "\($0)" }.joined(separator: " "))
                }
            }

            Button(action: {
                runMatrixMultiplication()
            }) {
                Text(isRunning ? "Running..." : "Run Matrix Multiplication")
                    .padding()
            }
            .buttonStyle(SquareButtonStyle())
            .disabled(isRunning)
        }
        .padding()
    }

    func runMatrixMultiplication() {
        isRunning = true

        // Simulating a matrix multiplication (replace with your actual matrices)
        let matrixA = generateRandomMatrix(100)
        let matrixB = generateRandomMatrix(100)

        DispatchQueue.global(qos: .userInitiated).async {
            // Perform the matrix multiplication with O(n^3) complexity
            resultMatrix = MatrixUtils.matrixMultiplication(matrixA, matrixB)

            DispatchQueue.main.async {
                isRunning = false
            }
        }
    }
    func generateRandomMatrix(_ size: Int) -> [[Int]] {
        var matrix = [[Int]]()

        for _ in 0..<size {
            var row = [Int]()
            for _ in 0..<size {
                row.append(Int.random(in: 0...9))
            }
            matrix.append(row)
        }

        return matrix
    }

}

struct SquareButtonStyle: ButtonStyle {
    func makeBody(configuration: Configuration) -> some View {
        configuration.label
            .foregroundColor(.white)
            .padding()
            .background(Color.blue)
            .cornerRadius(10)
            .scaleEffect(configuration.isPressed ? 0.9 : 1.0)
    }
}

struct ContentView_Previews: PreviewProvider {
    static var previews: some View {
        ContentView()
    }
}


//import SwiftUI
//
//struct ContentView: View {
//    var body: some View {
//        VStack {
//            Image(systemName: "globe")
//                .imageScale(.large)
//                .foregroundColor(.accentColor)
//            Text("Hello, world!")
//            Button(action: {
//                    runLoop()
//                        }) {
//                    Text("Run For Loop")
//                                .padding()
//                        }
//                    .buttonStyle(SquareButtonStyle())
//        }
//        .padding()
//    }
//    func runLoop() {
//            for _ in 0..<100 {
//                // Add any code you want to execute in each iteration here.
//            }
//        }
//}
//struct SquareButtonStyle: ButtonStyle {
//    func makeBody(configuration: Configuration) -> some View {
//        configuration.label
//            .foregroundColor(.white)
//            .padding()
//            .background(Color.blue)
//            .cornerRadius(10)
//            .scaleEffect(configuration.isPressed ? 0.9 : 1.0)
//    }
//}
//
//struct ContentView_Previews: PreviewProvider {
//    static var previews: some View {
//        ContentView()
//    }
//}
