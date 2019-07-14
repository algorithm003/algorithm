class Solution {
public:
    int findContentChildren(vector<int>& g, vector<int>& s) {
        priority_queue <int, vector<int>, greater<int> > cookies;
        priority_queue <int, vector<int>, greater<int> > greedies;
        int count=0;
        for(int i=0; i<s.size() ; i++)  cookies.push(s[i]);
        for(int i=0; i<g.size() ; i++)  greedies.push(g[i]);
        
        while(!cookies.empty() && !greedies.empty() ){
            int cookie = cookies.top(); 
            int greedy = greedies.top();
            
            if(cookie>=greedy){
                count++;
                greedies.pop();
            }
            cookies.pop();
        }
        

        return count;
        
    }
};