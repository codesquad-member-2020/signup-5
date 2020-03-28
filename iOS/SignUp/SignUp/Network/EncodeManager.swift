//
//  EncodeManager.swift
//  SignUp
//
//  Created by delma on 2020/03/28.
//  Copyright © 2020 delma. All rights reserved.
//

import Foundation
class EncodeManager {
    let encoder = JSONEncoder()

    func joinRequestEncoding(id: String, password: String, name: String, birthday: String, sex: String, email: String, phoneNumber: String, interest: String) -> (url: String, data: Data?) {
        let url = "https://signup-5-test-deploy.herokuapp.com/join"
         let userInfo = UserInfo(userId: id, password: password, name: name, birthday: birthday, sex: sex, email: email, phoneNumber: phoneNumber, interest: interest)
        let data = try? encoder.encode(userInfo)
        
        return (url, data)
    }
}
