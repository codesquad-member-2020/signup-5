//
//  InterestViewController.swift
//  SignUp
//
//  Created by delma on 2020/03/22.
//  Copyright © 2020 delma. All rights reserved.
//

import UIKit

class InterestViewController: UIViewController, UITextFieldDelegate {

    @IBOutlet var interestTextField: UITextField!
    private var interest: [String] = []
    
    override func viewDidLoad() {
        super.viewDidLoad()
        interestTextField.delegate = self
    }
  
    func textFieldShouldReturn(_ textField: UITextField) -> Bool {
        let text = textField.text!
        interest.append(text)
        textField.text! = ""
        print(interest)
        return true
    }
    
}
