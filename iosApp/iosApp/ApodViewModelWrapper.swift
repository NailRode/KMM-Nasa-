//
//  ApodViewModelWrapper.swift
//  iosApp
//
//  Created by Rode, Nail Emil on 12.05.23.
//  Copyright © 2023 orgName. All rights reserved.
//

import Foundation
import shared

final class ApodViewModelWrapper: ObservableObject {
    
    let viewModel: ApodViewModel = Koin.instance.get()
    
    
    @Published private(set) var apod: APOD? = nil
    
    
    init(){
        self.apod = viewModel.apod
    }
    
}
