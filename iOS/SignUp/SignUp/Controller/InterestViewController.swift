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
    @IBOutlet var collectionView: InterestCollectionView!
    @IBOutlet var interestAssistLabel: UILabel!
    
    var id: String?
    var password: String?
    var name: String?
    var birthDate: String?
    var gender: String?
    var phoneNumber: String?
    var email: String?
    
    private var interest: [String] = [] {
        didSet {
            guard let lastInterest = interest.last else { return }
            NotificationCenter.default.post(name: .addInterest , object: nil, userInfo: ["interest": lastInterest ])
        }
    }
    
    override func viewDidLoad() {
        super.viewDidLoad()
        interestTextField.delegate = self
        
        setUI()
    }
    
    func setUI() {
        interestAssistLabel.text = "관심사를 3개 이상 입력해주세요"
        interestAssistLabel.textColor = .green
    }
    
    func textFieldShouldReturn(_ textField: UITextField) -> Bool {
        let text = textField.text!
        interest.append(text)
        textField.text! = ""
        
        if interest.count >= 3 {
            interestAssistLabel.text = ""
        }
        
        return true
    }
    
    @IBAction func movePreviousScene(_ sender: Any) {
        self.dismiss(animated: true, completion: nil)
    }
    
    @IBAction func moveNextScene(_ sender: Any) {
        if let nextScene = self.storyboard?.instantiateViewController(withIdentifier: "LoginViewController") as? LoginViewController {
            
            nextScene.modalPresentationStyle = .fullScreen
            self.present(nextScene, animated: true)
        }
    }
}