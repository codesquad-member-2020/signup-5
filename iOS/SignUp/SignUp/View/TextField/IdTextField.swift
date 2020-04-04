//
//  IdTextField.swift
//  SignUp
//
//  Created by delma on 2020/03/24.
//  Copyright © 2020 delma. All rights reserved.
//

import UIKit

class IdTextField: UITextField, UITextFieldDelegate {
    
    private var isValidId = false
    
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
        judgeValidID(textField)
        let newLength = textField.text!.count + string.count - range.length
        return !(newLength > 20)
    }
    
    func judgeValidID(_ textField: UITextField) {
        //서버에서 아이디 가져와 중복되는지 확인해야 함
        var assistMessage = ""
        var assistColor = UIColor.black
        let text = textField.text!
        if !judgeCorrespondIdRegEx(id: text) {
            textField.layer.borderColor = UIColor.red.cgColor
            assistMessage = "5~20자의 영문 소문자, 숫자와 특수기호(_)(-) 만 사용 가능합니다."
            assistColor = UIColor.red
        }else if judgeCorrespondIdRegEx(id: text) {
            textField.layer.borderColor = UIColor.black.cgColor
            assistMessage = "사용 가능한 아이디입니다."
            assistColor = UIColor.green
            isValidId = true
        }
        NotificationCenter.default.post(name: .idAssistance, object: nil, userInfo: ["format":( message: assistMessage, color: assistColor)])
    }
    
    func judgeCorrespondIdRegEx(id: String) -> Bool {
        let idRegEx = "^(?=.*[a-z])(?=.*[0-9])[a-z0-9-_]{5,20}"
        let idTest = NSPredicate(format: "SELF MATCHES %@", idRegEx)
        return idTest.evaluate(with: id)
    }
    
    func judgeValidValue() -> Bool {
        return isValidId
    }
}
