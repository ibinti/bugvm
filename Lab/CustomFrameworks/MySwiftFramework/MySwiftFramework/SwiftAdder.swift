//
//  SwiftAdder.swift
//  MySwiftFramework
//
//  Created by Mario Zechner on 23/06/15.
//  Copyright (c) 2015 Mario Zechner. All rights reserved.
//

import Foundation

@objc
open class SwiftAdder: NSObject {
    open func add(_ a: Int32, b: Int32) -> Int32 {
        return a + b;
    }
}
