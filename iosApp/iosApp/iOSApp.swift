import SwiftUI

@main
struct iOSApp: App {
    
    @StateObject private var viewModelWrapper = ApodViewModelWrapper()
    
    init(){
        Koin.start()
    }
    
	var body: some Scene {
		WindowGroup {
            let gradient = LinearGradient(
                gradient: Gradient(colors: [Color.pink, Color.blue, Color.purple]),
                startPoint: .topLeading,
                endPoint: .bottomTrailing
            )
         
            Text(viewModelWrapper.apod?.title ?? "")
                .font(.system(size: 30))
                .foregroundColor(.clear)
                .overlay(
                    Text(viewModelWrapper.apod?.title ?? "")
                        .font(.system(size: 30))
                        .foregroundColor(.white)
                        .background(gradient)
                )
		}
	}
}
