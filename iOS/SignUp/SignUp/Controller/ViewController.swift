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
    @IBOutlet var passwordTextField: PasswordTextField!
    @IBOutlet var passwordConfirmTextField: PasswordConfirmTextField!
    @IBOutlet var nameTextField: NameTextField!
    
    @IBOutlet var idAssistLabel: UILabel!
    @IBOutlet var passwordAssistLabel: UILabel!
    @IBOutlet var passwordConfirmAssistLabel: UILabel!
    @IBOutlet var nameAssistLabel: UILabel!
    
    
    override func viewDidLoad() {
        super.viewDidLoad()
        setNotification()
    }
    
    func setNotification() {
        NotificationCenter.default.addObserver(self, selector: #selector(inputIdAssistComment(_:)), name: .idAssistance, object: nil)
        NotificationCenter.default.addObserver(self, selector: #selector(inputPasswordAssistComment(_:)), name: .passwordAssistance, object: nil)
        NotificationCenter.default.addObserver(self, selector: #selector(inputPasswordConfirmAssistComment(_:)), name: .passwordConfirmAssistance, object: nil)
        NotificationCenter.default.addObserver(self, selector: #selector(inputNameAssistComment(_:)), name: .nameAssistance, object: nil)
        
    }
    

    
    override func touchesBegan(_ touches: Set<UITouch>, with event: UIEvent?) {
        self.view.endEditing(true)
    }
    
    @IBAction func moveNextScene(_ sender: Any) {
        
        if idTextField.judgeValidValue(), passwordTextField.judgeValidValue(), passwordConfirmTextField.judgeValidValue(), nameTextField.judgeValidValue() {
            if let nextScene = self.storyboard?.instantiateViewController(withIdentifier: "PersonalInfoView") as? PersonalInfoViewController{
                
                nextScene.id = idTextField.text!
                nextScene.password = passwordTextField.text!
                nextScene.name = nameTextField.text!
                
                nextScene.modalPresentationStyle = .fullScreen
                self.present(nextScene, animated: true)
            }
        }
    }
    
    @IBAction func moveBeforeScene(_ sender: Any) {
        self.dismiss(animated: true)
    }
    
    @objc func inputIdAssistComment(_ notification: Notification) {
        guard let format = notification.userInfo?["format"] as? (message: String, color: UIColor) else { return }
        idAssistLabel.text = format.message
        idAssistLabel.textColor = format.color
    }
    
    @objc func inputPasswordAssistComment(_ notification: Notification) {
        guard let format = notification.userInfo?["format"] as? (message: String, color: UIColor) else { return }
        passwordAssistLabel.text = format.message
        passwordAssistLabel.textColor = format.color
    }
    
    @objc func inputPasswordConfirmAssistComment(_ notification: Notification) {
        guard let format = notification.userInfo?["format"] as? (message: String, color: UIColor) else { return }
        passwordConfirmAssistLabel.text = format.message
        passwordConfirmAssistLabel.textColor = format.color
    }
    
    @objc func inputNameAssistComment(_ notification: Notification) {
           guard let format = notification.userInfo?["format"] as? (message: String, color: UIColor) else { return }
           nameAssistLabel.text = format.message
           nameAssistLabel.textColor = format.color
       }
}

extension Notification.Name {
    static let idAssistance = Notification.Name("idAssistance")
    static let passwordAssistance = Notification.Name("passwordAssistance")
    static let passwordConfirmAssistance = Notification.Name("passwordConfirmAssistance")
    static let nameAssistance = Notification.Name("nameAssistance")
}
