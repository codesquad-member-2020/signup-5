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
    
//    @IBOutlet var collectionViewFlowLayout: UICollectionViewFlowLayout! {
//        didSet {
//            collectionViewFlowLayout.estimatedItemSize = UICollectionViewFlowLayout.automaticSize
//            print("qqqqqqq")
//        }
//    }
    private var interest: [String] = [] {
        didSet {
            guard let lastInterest = interest.last else { return }
            NotificationCenter.default.post(name: .addInterest , object: nil, userInfo: ["interest": lastInterest ])
        }
    }
    
    override func viewDidLoad() {
        super.viewDidLoad()
        interestTextField.delegate = self
    }
  
    func textFieldShouldReturn(_ textField: UITextField) -> Bool {
        let text = textField.text!
        interest.append(text)
        textField.text! = ""
        return true
    }
    
    
}
