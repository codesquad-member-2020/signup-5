//
//  PersonalInfoViewController.swift
//  SignUp
//
//  Created by delma on 2020/03/22.
//  Copyright © 2020 delma. All rights reserved.
//

import UIKit

class PersonalInfoViewController: UIViewController, UITextFieldDelegate {
    
    @IBOutlet var birthDateTextField: UITextField!
    @IBOutlet var phoneNumberTextField: UITextField!
    @IBOutlet var emailTextField: UITextField!
    @IBOutlet var emailAssistLabel: UILabel!
    @IBOutlet var phoneNumberAssistLabel: UILabel!
    
    let datePicker: UIDatePicker = UIDatePicker()
    
    var selectedGender: String = "female"
    
    private var isBirthDateInput = false
    private var isValidEmail = false
    private var isValidPhoneNumber = false
    
    override func viewDidLoad() {
        super.viewDidLoad()
        birthDateTextField.delegate = self
        emailTextField.delegate = self
        phoneNumberTextField.delegate = self
        
        datePicker.addTarget(self, action: #selector(selectDate(_:)), for: .valueChanged)
    }
    
    
    @IBAction func selectGender(_ sender: UISegmentedControl) {
        switch sender.selectedSegmentIndex {
        case 0:
            selectedGender = "female"
        case 1:
            selectedGender = "male"
        default:
            break
        }
    }
    
    func setUpDatePicker() {
        datePicker.isHidden = false
        datePicker.frame = CGRect(x: 0, y: self.view.frame.height * (3/4), width: self.view.frame.width, height: self.view.frame.height * (1/4))
        datePicker.locale = NSLocale.init(localeIdentifier: "ko_KO") as Locale
        datePicker.datePickerMode = .date
        
        datePicker.minimumDate = Date(timeIntervalSinceNow: -24 * 60 * 60 * 365 * 99)
        datePicker.maximumDate = Date(timeIntervalSinceNow: -24 * 60 * 60 * 365 * 15)
        self.view.addSubview(datePicker)
    }
    
    @objc func selectDate(_ sender: UIDatePicker) {
        let formatter = DateFormatter()
        formatter.dateFormat = "yyyy년 MM월 dd일"
        birthDateTextField.text = formatter.string(from: sender.date)
        isBirthDateInput = true
    }
    
    func textFieldDidBeginEditing(_ textField: UITextField) {
        if textField == birthDateTextField { setUpDatePicker() }
    }
    
    func textField(_ textField: UITextField, shouldChangeCharactersIn range: NSRange, replacementString string: String) -> Bool {
        textField.layer.borderWidth = 1.0
        
        if textField == emailTextField {
            if !judgeValidEmail(textField.text!) {
                emailAssistLabel.text = "이메일 주소를 다시 확인해주세요"
                emailAssistLabel.textColor = .red
                textField.layer.borderColor = UIColor.red.cgColor
            }else {
                emailAssistLabel.text = ""
                textField.layer.borderColor = UIColor.black.cgColor
                isValidEmail = true
            }
        }
        
        if textField == phoneNumberTextField {
            if !judgeValidPhoneNumber(textField.text!) {
                phoneNumberAssistLabel.text = "형식에 맞지 않는 번호입니다"
                phoneNumberAssistLabel.textColor = .red
                textField.layer.borderColor = UIColor.red.cgColor
            }else {
                phoneNumberAssistLabel.text = ""
                textField.layer.borderColor = UIColor.black.cgColor
                isValidPhoneNumber = true
            }
        }
        return true
    }
    
    func judgeValidEmail(_ email: String) -> Bool {
        let emailRegEx = "^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$"
        let emailTest = NSPredicate(format: "SELF MATCHES %@", emailRegEx)
        return emailTest.evaluate(with: email)
    }
    
    func judgeValidPhoneNumber(_ number: String) -> Bool {
        let numberRegEx = "^010[0-9]{3,4}[0-9]{4}$"
        let numberTest = NSPredicate(format: "SELF MATCHES %@", numberRegEx)
        return numberTest.evaluate(with: number)
    }
    
    override func touchesBegan(_ touches: Set<UITouch>, with event: UIEvent?) {
        datePicker.isHidden = true
        self.view.endEditing(true)
    }
    
    @IBAction func moveNextScene(_ sender: UIButton) {
        if isValidEmail, isBirthDateInput, isValidPhoneNumber {
            if let vc = self.storyboard?.instantiateViewController(withIdentifier: "TermsViewController") as? TermsViewController{
                
                vc.modalPresentationStyle = .automatic
                self.present(vc, animated: true)
            }
        }
    }
    
    @IBAction func movePreviousScene(_ sender: Any) {
        self.dismiss(animated: true, completion: nil)
    }
}
