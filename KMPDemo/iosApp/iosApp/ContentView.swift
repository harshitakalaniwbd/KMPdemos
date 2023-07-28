import SwiftUI
import shared

struct ContentView: View {
    @State private var greetText = ""

       var body: some View {
           VStack {
               Text(greetText)

               Button(action: {
                   greetText = Greeting().greet()
               }) {
                   Text("Call Greeting")
                       .padding()
               }
               .buttonStyle(SquareButtonStyle())
           }
           .padding()
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
