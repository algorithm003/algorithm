class Solution {
    func countOfAtoms(_ formula: String) -> String {
        var stack: [[String: Int]] = [[:]]
        // iterate the str
        var i = 0
        let length = formula.count
        
        // inner function
        let handleLeftBracket: () -> Void = {
            stack.append([:])
            i += 1
        }
        
        let handleRightBracket: () -> Void = {
            if let dict = stack.popLast() {
                // get the outer number
                i += 1
                let iStart = i
                while i < length && formula[formula.index(formula.startIndex, offsetBy: i)].isNumber {
                    i += 1
                }
                let mutiplyRatios = i > iStart ? Int(String(formula[formula.index(formula.startIndex, offsetBy: iStart)..<formula.index(formula.startIndex, offsetBy: i)])) : 1
                if var previousDict = stack.popLast() {
                    for (element, count) in dict {
                        if let mutiple = mutiplyRatios {
                            let newCount = mutiple * count
                            previousDict[element, default: 0] += newCount
                        }
                    }
                    stack.append(previousDict)
                }
            }
        }
        
        let handleNormal: () -> Void = {
            var iStart = i
            i += 1
            // get the element name
            if i < length && formula[formula.index(formula.startIndex, offsetBy: i)].isLowercase {
                i += 1
            }
            let elementName = String(formula[formula.index(formula.startIndex, offsetBy: iStart)..<formula.index(formula.startIndex, offsetBy: i)])
            // get the volume
            iStart = i
            while i < length && formula[formula.index(formula.startIndex, offsetBy: i)].isNumber {
                i += 1
            }
            // the volume could be more than 9
            let volume = i > iStart ? Int(String(formula[formula.index(formula.startIndex, offsetBy: iStart)..<formula.index(formula.startIndex, offsetBy: i)])) : 1
            // set the dictionary
            if var dict = stack.popLast() {
                if let volume = volume {
                    dict[elementName, default: 0] += volume
                }
                stack.append(dict)
            }
        }
        let functionMap: [String: () -> Void] = ["(": handleLeftBracket, ")": handleRightBracket]
        
        // begin iterate
        while i < length {
            let curChar = String(formula[formula.index(formula.startIndex, offsetBy: i)])
            if let funcPointer = functionMap[curChar] {
                funcPointer()
            } else {
                handleNormal()
            }
        }
        
        // print output
        var output = ""
        if let map = stack.popLast() {
            let keys = map.keys.sorted {
                $0 < $1
            }
            for key in keys {
                output += key
                if let count = map[key] {
                    if count > 1 {
                        output += "\(count)"
                    }
                }
            }
        }
        
        return output
    }
}
