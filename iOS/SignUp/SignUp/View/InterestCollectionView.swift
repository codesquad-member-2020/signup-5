//
//  InterestCollectionView.swift
//  SignUp
//
//  Created by delma on 2020/03/27.
//  Copyright © 2020 delma. All rights reserved.
//

import UIKit

class InterestCollectionView: UICollectionView, UICollectionViewDelegateFlowLayout, UICollectionViewDataSource, UICollectionViewDelegate {
      
    private var interest: [String] = []
    
    override init(frame: CGRect, collectionViewLayout layout: UICollectionViewLayout) {
        super.init(frame: frame, collectionViewLayout: layout)
        self.delegate = self
        self.dataSource = self
        setNotification()
    }
    
    required init?(coder: NSCoder) {
        super.init(coder: coder)
        self.delegate = self
        self.dataSource = self
        setNotification()
    }
    
    func collectionView(_ collectionView: UICollectionView, numberOfItemsInSection section: Int) -> Int {
        return interest.count
    }
    
    func collectionView(_ collectionView: UICollectionView, cellForItemAt indexPath: IndexPath) -> UICollectionViewCell {
        let row = self.interest[indexPath.row]
        let cell = collectionView.dequeueReusableCell(withReuseIdentifier: "InterestCollectionViewCell", for: indexPath) as! InterestCollectionViewCell

        cell.layer.cornerRadius = 20.0
        cell.interestLabel.text = row
        cell.cancelButton.tag = indexPath.row
        cell.cancelButton.addTarget(self, action: #selector(removeInterest(_:)), for: .touchDown)
        
        return cell
    }
    
    func collectionView(_ collectionView: UICollectionView, layout collectionViewLayout: UICollectionViewLayout, sizeForItemAt indexPath: IndexPath) -> CGSize {
        let cell = InterestCollectionViewCell()
        
        let interestLabel = UILabel()
        interestLabel.frame = CGRect(x: 0, y: 0, width: 100, height: 40)
        interestLabel.text = interest[indexPath.row]
        cell.addSubview(interestLabel)
        interestLabel.translatesAutoresizingMaskIntoConstraints = false
        interestLabel.topAnchor.constraint(equalTo: cell.topAnchor).isActive = true
        interestLabel.bottomAnchor.constraint(equalTo: cell.bottomAnchor).isActive = true
        interestLabel.leadingAnchor.constraint(equalTo: cell.leadingAnchor).isActive = true
        interestLabel.trailingAnchor.constraint(equalTo: cell.trailingAnchor).isActive = true
        cell.interestLabel = interestLabel
        cell.setNeedsLayout()
        let estimatedSize = cell.systemLayoutSizeFitting(CGSize(width: cell.interestLabel.bounds.width, height: 40))
 
        return .init(width: estimatedSize.width + 44, height: 40)
    }
    
    func setNotification() {
        NotificationCenter.default.addObserver(self, selector: #selector(addInterest(_:)), name: .addInterest, object: nil)
    }
    
    @objc func addInterest(_ notification: Notification) {
        guard let interestItem = notification.userInfo?["interest"] as? String else { return }
        interest.append(interestItem)
        self.reloadData()
    }
    
    @objc func removeInterest(_ sender: UIButton) {
        interest.remove(at: sender.tag)
        self.reloadData()
    }
    
}

extension Notification.Name {
    static let addInterest = Notification.Name("addInterest")
}
