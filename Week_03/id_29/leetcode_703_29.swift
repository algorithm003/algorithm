//
//  leetcode_703_29.swift
//  极客时间
//
//  Created by gavin hu on 2019/7/7.
//  Copyright © 2019 gavin hu. All rights reserved.
//

import Foundation

class KthLargest {
    
    /// 实现自己的堆
    struct Heap<Element> {
        // 用来存储元素的内部结构
        private var elements:[Element]
        /// 决定优先级的闭包
        private let priorityFunction: (Element, Element) -> Bool
        
        //// 堆是否为空
        public var isEmpty:Bool {
            return elements.isEmpty
        }
        
        /// 堆数量
        public var count:Int {
            return elements.count
        }
        
        /// 取回优先级最高的元素，不移除元素
        public func peek()->Element? {
            return elements.first
        }
        
        /// 给定索引是否是根节点
        public func isRoot(_ index:Int) ->Bool {
            return index == 0
        }
        
        /// 给定节点的左侧子节点索引（如果有的话）
        /// 左侧节点的所有总是奇数
        @inline(__always)
        public func leftChildIndex(of index:Int) ->Int {
            return index * 2 + 1
        }
        
        /// 给定节点的右侧子节点索引（如果有的话）
        /// 右侧节点的所有总是偶数
        @inline(__always)
        public func rightChildIndex(of index:Int) ->Int {
            return index * 2 + 2
        }
        
        /// 给定节点的父节点索引
        @inline(__always)
        public func parentIndex(of index: Int) -> Int {
            return (index - 1) / 2
        }
        
        /// firstIndex 索引对应的节点的优先级是否大于 secondIndex 索引对应的节点的优先级
        public func isHighPriority(at firstIndex: Int, than secondIndex: Int) -> Bool {
            return priorityFunction(elements[firstIndex], elements[secondIndex])
        }
        
        /// 比较父节点与子节点的优先级 返回优先级较大的节点的索引
        /// 如果子节点索引大于数组大小 则直接返回父节点索引
        /// 插入新元素时会用到此方法，比较它与父节点的优先级
        public func highestPriorityIndex(of parentIndex: Int, and childIndex: Int) -> Int {
            if childIndex < count, isHighPriority(at: childIndex, than: parentIndex) {
                return childIndex
            }
            return parentIndex
        }
        
        /// 返回给定节点的子节点中优先级最高的子节点序列
        /// 父节点先与左侧子节点比较，得出高优先级的索引，再把得到的索引与右侧子节点比较，得出最高优先级的子节点（结果可能是父节点优先级最大）
        /// 删除元素后，会用此方法重新排序
        public func highestPriorityIndex(for parent: Int) -> Int {
            return highestPriorityIndex(of: highestPriorityIndex(of: parent, and: leftChildIndex(of: parent)), and: rightChildIndex(of: parent))
        }
        
        /// 简单封装交换数组中两个元素的方法
        private mutating func swapElementsAt(_ firstIndex: Int, _ secondInx: Int) {
            guard firstIndex != secondInx else {
                return
            }
            elements.swapAt(firstIndex, secondInx)
        }
        
        public mutating func insert(_ element:Element) {
            elements.append(element)
            swim(elementAtIndex: count - 1)
        }
        
        /// 添加新元素
        /// 将元素追加到数组最后（即 添加到不完整级别的最左边的位置）
        /// 然后将其父节点比较优先级（swim：向上浮）
        public mutating func insert<S: Sequence>(_ sequence: S) where S.Iterator.Element == Element {
            for item in sequence {
                insert(item)
            }
        }
        
        /// 将给定索引位置的节点向上浮动
        private mutating func swim(elementAtIndex index: Int) {
            /// 父节点索引
            let parent = parentIndex(of: index)
            
            /// 如果给定索引是根节点 或者其优先级不高于其父节点 则直接返回，停止浮动
            guard !isRoot(index), isHighPriority(at: index, than: parent) else {
                return
            }
            /// 否则，就交换两处索引的节点
            swapElementsAt(index, parent)
            /// 交换后，其现在索引是交换前父节点的索引 也就是 第一行的`parent`，进行递归，直到 （变为根节点 || 不大于其父节点优先级）
            swim(elementAtIndex: parent)
        }
        
        /// 删除优先级最高的元素， 也就是根节点元素
        @discardableResult
        public mutating func remove() -> Element? {
            guard !isEmpty else {return nil}
            swapElementsAt(0, count - 1)
            let element = elements.removeLast()
            if !isEmpty {
                sink(elementAtIndex: 0)
            }
            return element
        }
        
        /// 将元素下沉
        /// 自身与两个子节点进行优先级比较，如果优先级比两个子节点高则不再进行操作
        /// 将自己与优先级最高的子节点交换位置，
        /// 交换位置后，进行递归操作
        private mutating func sink(elementAtIndex index: Int) {
            let childIndex = highestPriorityIndex(for: index)
            if index == childIndex { return }
            swapElementsAt(index, childIndex)
            sink(elementAtIndex: childIndex)
        }
        
        public init(elements: [Element] = [], sortedBy: @escaping (Element, Element) -> Bool) {
            self.elements = elements
            self.priorityFunction = sortedBy
            buildHeap()
        }
        
        private mutating func buildHeap() {
            for index in (0 ..< count / 2).reversed() {
                sink(elementAtIndex: index)
            }
        }
        
        /// 将指定位置的元素移除
        /// 如果指定位置超出内部数组大小 直接 return nil
        /// 如果指定位置是内部数组最后一个元素 将其移除出数组并返回
        /// 其他情况：将其与最后一个元素互换位置，操作基本上 remove 一致
        @discardableResult
        public mutating func remove(at index: Int) -> Element? {
            guard index < elements.count else { return nil }
            
            let size = count - 1
            
            if index == size {
                return elements.removeLast()
            }
            swapElementsAt(index, size)
            let element = elements.removeLast()
            sink(elementAtIndex: index)
            return element
        }
        
        /// 移除指定位置的元素然后添加新的元素
        public mutating func replace(index: Int, value: Element) {
            guard index < count else { return }
            remove(at: index)
            insert(value)
        }
    }
    
    
    public struct PriorityQueue<T> {
        private var heap:Heap<T>
        
        public init(sortBy: @escaping (T, T) -> Bool) {
            heap = Heap(sortedBy: sortBy)
        }
        
        public var isEmpty: Bool {
            return heap.isEmpty
        }
        
        public var count: Int {
            return heap.count
        }
        
        public func peek() -> T? {
            return heap.peek()
        }
        
        public mutating func enqueue(_ element: T) {
            return heap.insert(element)
        }
        
        @discardableResult
        public mutating func dequeue() -> T? {
            return heap.remove()
        }
        
        public mutating func changePriority(index i: Int, value: T) {
            heap.replace(index: i, value: value)
        }
    }
    
    private var k:Int
    private var queue:PriorityQueue<Int>
    
    init(_ k: Int, _ nums: [Int]) {
        self.k = k
        self.queue = PriorityQueue.init(sortBy: { (a, b) -> Bool in
            a < b
        })
        for num in nums {
            // 堆不满的时候
            if self.queue.count < k {
                self.queue.enqueue(num)
            }else {
                if self.queue.peek()! < num {
                    self.queue.dequeue()
                    self.queue.enqueue(num)
                }
            }
        }
        
    }
    
    func add(_ val: Int) -> Int {
        print(queue)
        if self.queue.count < k {
            self.queue.enqueue(val)
        }else{
            if self.queue.peek() ?? Int.min < val {
                self.queue.dequeue()
                self.queue.enqueue(val)
            }
        }
        return self.queue.peek()!
    }
}


let s = KthLargest.init(2, [0])
s.add(-1)
s.add(1)
s.add(-2)
s.add(-4)
s.add(3)
