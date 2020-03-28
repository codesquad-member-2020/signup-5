//
//  RequestManager.swift
//  SignUp
//
//  Created by delma on 2020/03/28.
//  Copyright © 2020 delma. All rights reserved.
//

import Foundation

class RequestManager {
    enum HTTPMethod: String {
        case get = "GET"
        case post = "POST"
        case put = "PUT"
        case delete = "DELETE"
    }
    
    func request(url: String, methodType: HTTPMethod, body: Data? = nil) {
        guard let url = URL(string: url) else { return }
        
        var request = URLRequest(url: url)
        request.httpMethod = methodType.rawValue
        request.setValue("application/json", forHTTPHeaderField: "Content-Type")
        request.httpBody = body
        
        let session = URLSession.shared
        let task = session.dataTask(with: request) { (data, response, error) in
            guard error == nil else { return }
            
            do {
                let anyData = try JSONSerialization.jsonObject(with: data!, options: [])
                print(anyData)
                } catch {
                
            }
        }
        
        task.resume()
    }
}
