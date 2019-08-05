class Solution {
public:
    int ladderLength(string beginWord, string endWord, vector<string>& wordList) {
        unordered_set<string> wordSet(wordList.begin(), wordList.end());
        if(!wordSet.count(endWord))
            return 0;
        
        int res = 0;
        
        queue<string> q{{beginWord}};
        while(!q.empty()){
            int size = q.size();
            for(int i = 0; i < size; i++){
                string cur = q.front();
                q.pop();
            
                if(cur == endWord)
                    return res + 1;
            
                int n = cur.size();
                for(int j = 0; j < n; j++){
                    string newCur = cur;
                    for(char ch = 'a'; ch <= 'z'; ch++){
                        newCur[j] = ch;
                    
                        if(wordSet.count(newCur) && newCur != cur){
                            q.push(newCur);
                            wordSet.erase(newCur);
                        }
                    }
                } 
            }
            
            res++;
        }
        
        return 0; 
    }
        
//         unordered_set<string> wordSet(wordList.begin(), wordList.end());
//         if(!wordSet.count(endWord))
//             return 0;
        
//         unordered_map<string, int> len{{beginWord, 1}};
        
//         queue<string> q{{beginWord}};
//         while(!q.empty()){
//             string word = q.front();
//             q.pop();
            
//             int n = word.size();
//             for(int i = 0; i < n; i++){
//                 string newWord = word;
//                 for(char ch = 'a'; ch <= 'z'; ch++){
//                     newWord[i] = ch;
                    
//                     if(wordSet.count(newWord) && newWord == endWord)
//                         return len[word] + 1;
                    
//                     if(wordSet.count(newWord) && !len.count(newWord)){
//                         q.push(newWord);
//                         len[newWord] = len[word] + 1;
//                     }
//                 }
//             }
//         }
        
//         return 0;
//     }
};