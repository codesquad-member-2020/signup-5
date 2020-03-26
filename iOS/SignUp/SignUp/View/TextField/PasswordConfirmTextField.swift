//
//  PasswordConfirmTextField.swift
//  SignUp
//
//  Created by delma on 2020/03/24.
//  Copyright © 2020 delma. All rights reserved.
//

import UIKit

class PasswordConfirmTextField: UITextField, UITextFieldDelegate {
    
    private var isValidPasswordConfirm = false
    private var firstPassword = ""
    
    override init(frame: CGRect) {
        super.init(frame: frame)
        configure()
        self.delegate = self
        addObserver()
    }
    
    required init?(coder: NSCoder) {
        super.init(coder: coder)
        configure()
        self.delegate = self
        addObserver()
    }
    
    func configure() {
        self.layer.borderWidth = 1.0
    }
    
    func textField(_ textField: UITextField, shouldChangeCharactersIn range: NSRange, replacementString string: String) -> Bool {
        judgeCorrespondPassword(textField)
        return true
    }
    
    
    func judgeCorrespondPassword(_ textField: UITextField) {
        let text = textField.text!
        var assistMessage = ""
        var assistColor = UIColor.red
        
        if text != firstPassword {
            textField.layer.borderColor = UIColor.red.cgColor
            assistMessage = "비밀번호가 일치하지 않습니다."
            assistColor = .red
        }else {
            textField.layer.borderColor = UIColor.black.cgColor
            assistMessage = "비밀번호가 일치합니다."
            assistColor = .green
            isValidPasswordConfirm = true
        }
         NotificationCenter.default.post(name: .passwordConfirmAssistance, object: nil, userInfo: ["format":( message: assistMessage, color: assistColor)])
    }
    
    
    func judgeValidValue() -> Bool {
        return isValidPasswordConfirm
    }
    
    func addObserver() {
        NotificationCenter.default.addObserver(self, selector: #selector(passPassword(_:)), name: .changedPassword, object: nil)
      }
    
    @objc func passPassword(_ notification: Notification) {
        guard let password = notification.userInfo?["password"] as? String else { return }
        firstPassword = password
    }
      
}

extension Notification.Name {
    static let changedPassword = Notification.Name("changedPassword")
}
