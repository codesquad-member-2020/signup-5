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
    
    override func viewDidLoad() {
        super.viewDidLoad()
        idTextField.delegate = self
       
    }
   

    
    func textField(_ textField: UITextField, shouldChangeCharactersIn range: NSRange, replacementString string: String) -> Bool {
        textField.layer.borderWidth = 1.0
        
        if textField.text!.count < 10 {
            textField.layer.borderColor = UIColor.red.cgColor
        }else if textField.text!.count >= 10, textField.text!.count < 20 {
            textField.layer.borderColor = UIColor.green.cgColor
        }
        let newLength = (textField.text?.count)! + string.count - range.length
        return !(newLength > 20)
    }

    
    
    @IBAction func pressNextBtn(_ sender: Any) {
        print(idTextField.text!)
    }
    
}

