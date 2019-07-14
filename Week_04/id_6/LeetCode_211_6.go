package main

type WordDictionary struct {
	sons [26]*WordDictionary
	end int
}


func Constructor() WordDictionary {
	return WordDictionary{}
}

func (this *WordDictionary) AddWord(word string)  {
	for _, c := range word {
		idx := c - 'a'
		if this.sons[idx] == nil {
			this.sons[idx] = &WordDictionary{}
		}
		this = this.sons[idx]
	}
	this.end++
}


func (this *WordDictionary) Search(word string) bool {
	for i, c := range word {
		if c != '.' {
			idx := c - 'a'
			if this.sons[idx] == nil {
				return false
			}
			this = this.sons[idx]
		}else {
			for _, son := range this.sons {
				if son == nil {
					continue
				}
				this = son
				if i == len(word) - 1 {
					if this.end > 0 {
						return true
					}
					continue
				}
				if this.Search(word[(i+1):]) {
					return true
				}
			}
			return false
		}
	}

	if this.end > 0 {
		return true
	}
	return false
}