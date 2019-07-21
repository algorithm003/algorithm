//
//  leetcode_29_720.swift
//  极客时间
//
//  Created by gavin hu on 2019/7/21.
//  Copyright © 2019 gavin hu. All rights reserved.
//

import Foundation

/*
 使用Trie 树 来实现
 */

class Trie {
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
    
    
    init() {
        root = Node()
        
    }
    
    
    
    public func add(_ word:String) {
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
    
    public func longestInDictionary()->String {
        return longest(root, "")
    }
    
    private func longest(_ node:Node? ,_ curRes:String)-> String {
        if node == nil { return curRes }
        
        var result = curRes
        for key in node!.map.keys {
            if node!.map[key]!.isWord {
                let res =  longest(node!.map[key]!,"\(curRes)\(key)")
                if result.count > res.count {
                    break
                }else if result.count == res.count {
                    result = result > res ? res : result
                }else {
                    result = res
                }
            }else {
                continue
            }
        }
        return result
    }
    
}

class Solution {
    func longestWord(_ words: [String]) -> String {
        let trie = Trie()
        for word in words {
            trie.add(word)
        }
        return trie.longestInDictionary()
    }
}
