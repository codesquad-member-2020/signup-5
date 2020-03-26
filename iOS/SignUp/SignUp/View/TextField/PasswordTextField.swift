//
//  PasswordTextField.swift
//  SignUp
//
//  Created by delma on 2020/03/24.
//  Copyright © 2020 delma. All rights reserved.
//

import UIKit

class PasswordTextField: UITextField, UITextFieldDelegate {
    
    private var isValidPassword = false
    
    override init(frame: CGRect) {
        super.init(frame: frame)
        configure()
        self.delegate = self
        
    }
    
    required init?(coder: NSCoder) {
        super.init(coder: coder)
        configure()
        self.delegate = self
    }
    
    func configure() {
        self.layer.borderWidth = 1.0
    }
    
    func textField(_ textField: UITextField, shouldChangeCharactersIn range: NSRange, replacementString string: String) -> Bool {
        judgeValidPassword(textField)
        let newLength = textField.text!.count + string.count - range.length
        return !(newLength > 16)
    }
    
    func judgeValidPassword(_ textField: UITextField) {
        let text = textField.text!
        var assistMessage = ""
        var assistColor = UIColor.red
        textField.layer.borderColor = UIColor.red.cgColor
        let specialCharacters = ["!","@","#","$","%"]
        
        let isContainUpperCase = text.contains(where: { $0.isUppercase})
        let isContainNumeric = text.contains(where: { $0.isNumber })
        let isContainSpecialCharacter = text.contains(where: { specialCharacters.contains(String($0)) })
        
        if text.count > 16 || text.count < 8 {
           assistMessage = "8자 이상 16자 이하로 입력해주세요."
        }else if !isContainUpperCase {
           assistMessage = "영문 대문자를 최소 1자 이상 포함해주세요."
        }else if !isContainNumeric {
           assistMessage = "숫자를 최소 1자 이상 포함해주세요."
        }else if !isContainSpecialCharacter {
            assistMessage = "특수문자를 최소 1자 이상 포함해주세요."
        }else {
            assistMessage = "안전한 비밀번호입니다."
            assistColor = .green
            textField.layer.borderColor = UIColor.black.cgColor
            isValidPassword = true
            NotificationCenter.default.post(name: .changedPassword, object: nil, userInfo: ["password":text])
        }
        
        NotificationCenter.default.post(name: .passwordAssistance, object: nil, userInfo: ["format":( message: assistMessage, color: assistColor)])
        
    }
    
    func judgeValidValue() -> Bool {
        return isValidPassword
    }
    
  
}
