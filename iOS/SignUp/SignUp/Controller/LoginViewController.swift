//
//  LoginViewController.swift
//  SignUp
//
//  Created by delma on 2020/03/22.
//  Copyright © 2020 delma. All rights reserved.
//

import UIKit

class LoginViewController: UIViewController {

    override func viewDidLoad() {
        super.viewDidLoad()

    }
    
    @IBAction func moveJoinScene(_ sender: UIButton) {
           if let nextScene = self.storyboard?.instantiateViewController(withIdentifier: "ViewController") as? ViewController {
               
               nextScene.modalPresentationStyle = .fullScreen
               self.present(nextScene, animated: true)
           }
       }
}
