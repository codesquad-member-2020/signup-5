//
//  InterestCollectionViewCell.swift
//  SignUp
//
//  Created by delma on 2020/03/27.
//  Copyright © 2020 delma. All rights reserved.
//

import UIKit

class InterestCollectionViewCell: UICollectionViewCell {
    
    @IBOutlet var cancelButton: UIButton!
    @IBOutlet var interestLabel: UILabel!
    
    override init(frame: CGRect) {
        super.init(frame: frame)
        self.translatesAutoresizingMaskIntoConstraints = false
    }
    
    required init?(coder: NSCoder) {
        super.init(coder: coder)
        self.translatesAutoresizingMaskIntoConstraints = false
    }
}
