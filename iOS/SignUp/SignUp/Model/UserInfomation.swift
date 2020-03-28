//
//  UserInfomation.swift
//  SignUp
//
//  Created by delma on 2020/03/28.
//  Copyright © 2020 delma. All rights reserved.
//

import Foundation

struct UserInfo: Codable {
    var userId: String
    var password: String
    var name: String
    var birthday: String
    var sex: String
    var email: String
    var phoneNumber: String
    var interest: String
}
