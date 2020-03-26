//
//  NameTextField.swift
//  SignUp
//
//  Created by delma on 2020/03/24.
//  Copyright © 2020 delma. All rights reserved.
//

import UIKit

class NameTextField: UITextField, UITextFieldDelegate {
    
    private var isValidName = false
    
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
        judgeValidName(textField)
        
        return true
    }
    
    func judgeValidName(_ textField: UITextField) {
        let text = textField.text!
        var assistMessage = ""
        var assistColor = UIColor.red
        
        if text.isEmpty {
            textField.layer.borderColor = UIColor.red.cgColor
            assistMessage = "이름은 필수입력항목입니다."
            assistColor = .red
        }else {
            textField.layer.borderColor = UIColor.black.cgColor
            assistMessage = ""
            isValidName = true
        }
        NotificationCenter.default.post(name: .nameAssistance, object: nil, userInfo: ["format":( message: assistMessage, color: assistColor)])
        
    }
    
    func judgeValidValue() -> Bool {
        return isValidName
    }
}
