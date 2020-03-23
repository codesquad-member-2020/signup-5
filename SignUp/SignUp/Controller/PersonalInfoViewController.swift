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
        
    }
    
    func setUpDatePicker() {
        datePicker.frame = CGRect(x: 0, y: self.view.frame.height * (3/4), width: self.view.frame.width, height: self.view.frame.height * (1/4))
        datePicker.locale = NSLocale.init(localeIdentifier: "ko_KO") as Locale
        datePicker.datePickerMode = .date
        self.view.addSubview(datePicker)
    }

    
    func textFieldDidBeginEditing(_ textField: UITextField) {
        setUpDatePicker()
    }

}
