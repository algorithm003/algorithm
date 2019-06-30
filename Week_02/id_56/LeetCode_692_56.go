func topKFrequent(words []string, k int) []string {
    
    count := make(map[string]int, len(words))
    
    for _, v := range words {
        count[v]++
    }
    
    fw := make(freWords, 0, len(count))
    
    for w, c := range count {
        fw = append(fw, &entry{
            word:      w,
            frequence: c,
        })
    }
    
    sort.Sort(fw)
    
    res := make([]string, k)
    
    for i := 0; i < k; i++ {
        res[i] = fw[i].word
    }
    
    return res
}

type entry struct {
    word       string
    frequence  int
}

type freWords []*entry

func (f freWords) Len() int {
    return len(f)
}

func (f freWords) Less(i, j int) bool {
    if f[i].frequence == f[j].frequence {
        return f[i].word < f[j].word
    }
    
    return f[i].frequence > f[j].frequence
}

func (f freWords) Swap(i, j int) {
    f[i], f[j] = f[j], f[i]
}
