//
//  ViewController.swift
//  SignUp
//
//  Created by delma on 2020/03/22.
//  Copyright © 2020 delma. All rights reserved.
//

import UIKit

class ViewController: UIViewController, UITextFieldDelegate {
    
    @IBOutlet var idTextField: IdTextField!
    @IBOutlet var passwordTextField: UITextField!
    @IBOutlet var passwordConfirmTF: UITextField!
    @IBOutlet var nameTF: UITextField!
    
    @IBOutlet var idAssistLabel: UILabel!
    @IBOutlet var passwordAssistLabel: UILabel!
    @IBOutlet var passwordConfirmAssistLabel: UILabel!
    @IBOutlet var nameAssistLabel: UILabel!
    
    private var isValidPassword = false
    private var isValidPasswordConfirm = false
    private var isValidName = false
    
    override func viewDidLoad() {
        super.viewDidLoad()
        passwordTextField.delegate = self
        passwordConfirmTF.delegate = self
        nameTF.delegate = self
        setUpUI()
        
        NotificationCenter.default.addObserver(self, selector: #selector(inputIdAssistComment(_:)), name: .idAssistance, object: nil)
    }
    
    func setUpUI() {
        passwordTextField.layer.borderWidth = 1.0
        passwordConfirmTF.layer.borderWidth = 1.0
        nameTF.layer.borderWidth = 1.0
    }
    
    func textField(_ textField: UITextField, shouldChangeCharactersIn range: NSRange, replacementString string: String) -> Bool {
        
        switch textField {
        case passwordTextField:
            judgeValidPassword(textField)
            let newLength = textField.text!.count + string.count - range.length
            return !(newLength > 16)
        case passwordConfirmTF:
            judgeCorrespondPassword(textField)
        case nameTF:
            judgeValidName(textField)
        default: break
            
        }
        
        return true
    }
    
    override func touchesBegan(_ touches: Set<UITouch>, with event: UIEvent?) {
        self.view.endEditing(true)
    }
    
    
    func judgeValidPassword(_ textField: UITextField) {
        let text = textField.text!
        passwordAssistLabel.textColor = .red
        textField.layer.borderColor = UIColor.red.cgColor
        let specialCharacters = ["!","@","#","$","%"]
        
        let isContainUpperCase = text.contains(where: { $0.isUppercase})
        let isContainNumeric = text.contains(where: { $0.isNumber })
        let isContainSpecialCharacter = text.contains(where: { specialCharacters.contains(String($0)) })
        
        if text.count > 16 || text.count < 8 {
            passwordAssistLabel.text = "8자 이상 16자 이하로 입력해주세요."
        }else if !isContainUpperCase {
            passwordAssistLabel.text = "영문 대문자를 최소 1자 이상 포함해주세요."
        }else if !isContainNumeric {
            passwordAssistLabel.text = "숫자를 최소 1자 이상 포함해주세요."
        }else if !isContainSpecialCharacter {
            passwordAssistLabel.text = "특수문자를 최소 1자 이상 포함해주세요."
        }else {
            passwordAssistLabel.text = "안전한 비밀번호입니다."
            passwordAssistLabel.textColor = .green
            textField.layer.borderColor = UIColor.black.cgColor
            isValidPassword = true
        }
        
    }
    
    func judgeCorrespondPassword(_ textField: UITextField) {
        let text = textField.text!
        if text != passwordTextField.text! {
            textField.layer.borderColor = UIColor.red.cgColor
            passwordConfirmAssistLabel.text = "비밀번호가 일치하지 않습니다."
            passwordConfirmAssistLabel.textColor = .red
        }else {
            textField.layer.borderColor = UIColor.black.cgColor
            passwordConfirmAssistLabel.text = "비밀번호가 일치합니다."
            passwordConfirmAssistLabel.textColor = .green
            isValidPasswordConfirm = true
        }
    }
    
    func judgeValidName(_ textField: UITextField) {
        let text = textField.text!
        if text.isEmpty {
            textField.layer.borderColor = UIColor.red.cgColor
            nameAssistLabel.text = "이름은 필수입력항목입니다."
            nameAssistLabel.textColor = .red
        }else {
            textField.layer.borderColor = UIColor.black.cgColor
            nameAssistLabel.text = ""
            isValidName = true
        }
    }
    
    
    @IBAction func pressNextBtn(_ sender: Any) {
        
        if idTextField.judgeValidValue(), isValidPassword, isValidPasswordConfirm, isValidName {
            if let vc = self.storyboard?.instantiateViewController(withIdentifier: "PersonalInfoView") as? PersonalInfoViewController{
                
                vc.modalPresentationStyle = .fullScreen
                self.present(vc, animated: true)
            }
        }
    }
    
    @objc func inputIdAssistComment(_ notification: Notification) {
        guard let format = notification.userInfo?["format"] as? (message: String, color: UIColor) else { return }
        idAssistLabel.text = format.message
        idAssistLabel.textColor = format.color
    }
    
}

extension Notification.Name {
    static let idAssistance = Notification.Name("idAssistance")
    static let passwordAssistance = Notification.Name("passwordAssistance")
    static let passwordConfirmAssistance = Notification.Name("passwordConfirmAssistance")
    static let nameAssistance = Notification.Name("nameAssistance")
}
