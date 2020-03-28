//
//  TermsViewController.swift
//  SignUp
//
//  Created by delma on 2020/03/22.
//  Copyright © 2020 delma. All rights reserved.
//

import UIKit

class TermsViewController: UIViewController {
    
    @IBOutlet var termsDescriptionTextView: UITextView!
    
    var id: String?
    var password: String?
    var name: String?
    var birthDate: String?
    var gender: String?
    var phoneNumber: String?
    var email: String?
    
    override func viewDidLoad() {
        super.viewDidLoad()
        setTermsDescription()
    }
    
    override func viewDidAppear(_ animated: Bool) {
        setActionSheet()
    }
    
    func setTermsDescription() {
        termsDescriptionTextView.text = "정보통신망법 규정에 따라 코드스쿼드에 회원가입 신청하시는 분께 수집하는 개인정보의 항목, 개인정보의 수집 및 이용목적, 개인정보의 보유 및 이용기간을 안내 드리오니 자세히 읽은 후 동의하여 주시기 바랍니다.\n\n 1. 수집하는 개인정보 이용자는 회원가입을 하지 않아도 대부분의 코드스쿼드 서비스를 회원과 동일하게 이용할 수 있습니다. 이용자가 개인화 혹은 회원제 서비스를 이용하기 위해 회원가입을 할 경우, 코드스쿼드는 서비스 이용을 위해 필요한 최소한의 개인정보를 수집합니다. 회원가입 시점에 코드스쿼드가 이용자로부터 수집하는 개인정보는 아래와 같습니다. - 회원 가입 시에 ‘아이디, 비밀번호, 이름, 생년월일, 성별, 휴대전화번호’를 필수항목으로 수집합니다. \n\n서비스 이용 과정에서 이용자로부터 수집하는 개인정보는 아래와 같습니다. 코드스쿼드 내의 개별 서비스 이용, 이벤트 응모 및 경품 신청 과정에서 해당 서비스의 이용자에 한해 추가 개인정보 수집이 발생할 수 있습니다. 추가로 개인정보를 수집할 경우에는 해당 개인정보 수집 시점에서 이용자에게 ‘수집하는 개인정보 항목, 개인정보의 수집 및 이용목적, 개인정보의 보관기간’에 대해 안내 드리고 동의를 받습니다."
        termsDescriptionTextView.isEditable = false
        termsDescriptionTextView.font = UIFont.systemFont(ofSize: 15.0)
    }
    
    func setActionSheet() {
        let actionSheet = UIAlertController(title: nil, message: nil, preferredStyle: .actionSheet)
        let agree = UIAlertAction(title: "동의", style: .default) { (agree) in
            if let nextScene = self.storyboard?.instantiateViewController(withIdentifier: "InterestViewController") as? InterestViewController {
                
                nextScene.id = self.id
                nextScene.password = self.password
                nextScene.name = self.name
                nextScene.birthDate = self.birthDate
                nextScene.phoneNumber = self.phoneNumber
                nextScene.email = self.email
                
                nextScene.modalPresentationStyle = .fullScreen
                self.present(nextScene, animated: false)
            }
        }
        let cancel = UIAlertAction(title: "취소", style: .cancel) { (cancel) in
            self.dismiss(animated: true)
        }
        
        actionSheet.addAction(agree)
        actionSheet.addAction(cancel)
        
        present(actionSheet, animated: false)
    }


  
}
