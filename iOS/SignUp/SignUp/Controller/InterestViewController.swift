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
    @IBOutlet var joinButton: UIButton!
    
    var id: String?
    var password: String?
    var name: String?
    var birthDate: String?
    var gender: String?
    var phoneNumber: String?
    var email: String?
    
    let requestManager = RequestManager()
    let encodeManager = EncodeManager()
    
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
        joinButton.isEnabled = false
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
            joinButton.isEnabled = true
        }
        
        return true
    }
    
    @IBAction func movePreviousScene(_ sender: Any) {
        self.dismiss(animated: true, completion: nil)
    }
    
    @IBAction func moveNextScene(_ sender: UIButton) {
        let interestString = interest.reduce("") { "\($0),"+"\($1)" }
        guard let id = id, let password = password, let name = name, let birthday = birthDate, let sex = gender, let email = email, let phoneNumber = phoneNumber else { return }
        
        let encodedData = encodeManager.joinRequestEncoding(id: id, password: password, name: name, birthday: birthday, sex: sex, email: email, phoneNumber: phoneNumber, interest: interestString)
        let requestResult = requestManager.request(url: encodedData.url, methodType: .post, body: encodedData.data)
        
        if requestResult {
            joinSuccessAlert()
        }else {
            joinFailAlert()
        }
        
    }
    
    func joinSuccessAlert() {
        let alert = UIAlertController(title: "가입 성공", message: "회원가입이 완료되었습니다", preferredStyle: .alert)
        let ok = UIAlertAction(title: "확인", style: .default) { (ok) in
            if let nextScene = self.storyboard?.instantiateViewController(withIdentifier: "LoginViewController") as? LoginViewController {
                
                nextScene.modalPresentationStyle = .fullScreen
                self.present(nextScene, animated: true)
            }
        }
        
        alert.addAction(ok)
        self.present(alert, animated: true)
    }
    
    func joinFailAlert() {
        let alert = UIAlertController(title: "오류 안내", message: "회원가입에 실패했습니다", preferredStyle: .alert)
        let ok = UIAlertAction(title: "확인", style: .default) { (ok) in
            if let nextScene = self.storyboard?.instantiateViewController(withIdentifier: "ViewController") as? ViewController {
                
                nextScene.modalPresentationStyle = .fullScreen
                self.present(nextScene, animated: true)
            }
        }
        
        alert.addAction(ok)
        self.present(alert, animated: true)
    }
    
    
}
