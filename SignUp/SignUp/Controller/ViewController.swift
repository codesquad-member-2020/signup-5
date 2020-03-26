//
//  ViewController.swift
//  SignUp
//
//  Created by delma on 2020/03/22.
//  Copyright © 2020 delma. All rights reserved.
//

import UIKit

class ViewController: UIViewController, UITextFieldDelegate {
    
    @IBOutlet var idTextField: UITextField!
    @IBOutlet var passwordTextField: UITextField!
    @IBOutlet var passwordConfirmTF: UITextField!
    @IBOutlet var nameTF: UITextField!
    
    @IBOutlet var idAssistLabel: UILabel!
    @IBOutlet var passwordAssistLabel: UILabel!
    @IBOutlet var passwordConfirmAssistLabel: UILabel!
    @IBOutlet var nameAssistLabel: UILabel!
    
    var isValidId = false
    var isValidPassword = false
    var isValidPasswordConfirm = false
    var isValidName = false
    
    override func viewDidLoad() {
        super.viewDidLoad()
        idTextField.delegate = self
        passwordTextField.delegate = self
        passwordConfirmTF.delegate = self
        nameTF.delegate = self
        
        setUpUI()
    }
    
    func setUpUI() {
        idTextField.layer.borderWidth = 1.0
        passwordTextField.layer.borderWidth = 1.0
        passwordConfirmTF.layer.borderWidth = 1.0
        nameTF.layer.borderWidth = 1.0
    }
    
    func textField(_ textField: UITextField, shouldChangeCharactersIn range: NSRange, replacementString string: String) -> Bool {
        
        switch textField {
        case idTextField:
            judgeValidID(textField)
            let newLength = textField.text!.count + string.count - range.length
            return !(newLength > 20)
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
    
    func judgeValidID(_ textField: UITextField) {
        //서버에서 아이디 가져와 중복되는지 확인해야 함
        let text = textField.text!
        if !judgeCorrespondIdRegEx(id: text) {
            textField.layer.borderColor = UIColor.red.cgColor
            idAssistLabel.text = "5~20자의 영문 소문자, 숫자와 특수기호(_)(-) 만 사용 가능합니다."
            idAssistLabel.textColor = UIColor.red
            
        }else {
            textField.layer.borderColor = UIColor.black.cgColor
            idAssistLabel.text = "사용 가능한 아이디입니다."
            idAssistLabel.textColor = UIColor.green
            isValidId = true
        }
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
    
    func judgeCorrespondIdRegEx(id: String) -> Bool {
        let idRegEx = "^(?=.*[a-z])(?=.*[0-9])[a-z0-9-_]{5,20}"
        let idTest = NSPredicate(format: "SELF MATCHES %@", idRegEx)
        return idTest.evaluate(with: id)
    }
    
    @IBAction func pressNextBtn(_ sender: Any) {
        if isValidId, isValidPassword, isValidPasswordConfirm, isValidName {
            if let vc = self.storyboard?.instantiateViewController(withIdentifier: "PersonalInfoView") as? PersonalInfoViewController{
                
                vc.modalPresentationStyle = .fullScreen
                self.present(vc, animated: true)
            }
        }
    }
    
}

