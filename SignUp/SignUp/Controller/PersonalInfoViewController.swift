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
    let datePicker: UIDatePicker = UIDatePicker()
    
    override func viewDidLoad() {
        super.viewDidLoad()
        birthDateTextField.delegate = self
        
        datePicker.addTarget(self, action: #selector(selectDate(_:)), for: .valueChanged)
        
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
    }
    
    func textFieldDidBeginEditing(_ textField: UITextField) {
        setUpDatePicker()
    }
    
    override func touchesBegan(_ touches: Set<UITouch>, with event: UIEvent?) {
        datePicker.isHidden = true
        self.view.endEditing(true)
    }
}
