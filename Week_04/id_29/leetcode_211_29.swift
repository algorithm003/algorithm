//
//  leetcode_211_29.swift
//  极客时间
//
//  Created by gavin hu on 2019/7/21.
//  Copyright © 2019 gavin hu. All rights reserved.
//

import Foundation

class WordDictionary {
    
    private class Node {
        var isWord:Bool
        var map:[Character:Node]
        
        init(_ isWord:Bool) {
            self.isWord = isWord
            self.map = [Character:Node]()
        }
        
        convenience init() {
            self.init(false)
        }
    }
    
    private var root:Node
    
    /** Initialize your data structure here. */
    init() {
        root = Node()
    }
    
    /** Adds a word into the data structure. */
    func addWord(_ word: String) {
        var cur = root
        for c in word {
            if cur.map[c] == nil {
                cur.map[c] = Node()
            }
            cur = cur.map[c]!
        }
        if cur.isWord == false {
            cur.isWord = true
        }
    }
    
    
    private func bfs(_ node: Node, _ chars: [Character], _ nextIdx: Int) -> Bool {
        if nextIdx == chars.count {
            return node.isWord
        }
        for (nextChar, nextNode) in node.map where nextChar == chars[nextIdx] || chars[nextIdx] == "." {
            if bfs(nextNode, chars, nextIdx + 1) {
                return true
            }
        }
        return false
    }
    
    
    func search(_ word: String) -> Bool {
        return bfs(root, Array(word), 0)
    }
}
