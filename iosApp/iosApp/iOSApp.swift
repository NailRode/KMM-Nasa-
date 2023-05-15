import SwiftUI
import shared
import KMMViewModelCore
import KMMViewModelSwiftUI

@main
struct iOSApp: App {
    
    @StateViewModel var viewModel: ApodViewModel = Koin.instance.get()
    
    
    init() {
        Koin.start()
    }
    
    
	var body: some Scene {
		WindowGroup {
            let gradient = LinearGradient(
                gradient: Gradient(colors: [Color.pink, Color.blue, Color.purple]),
                startPoint: .topLeading,
                endPoint: .bottomTrailing
            )
         
            Text(viewModel.apod?.title ?? "")
                .font(.system(size: 30))
                .foregroundColor(.clear)
                .overlay(
                    Text(viewModel.apod?.title ?? "")
                        .font(.system(size: 30))
                        .foregroundColor(.white)
                        .background(gradient)
                )
		}
	}
}
