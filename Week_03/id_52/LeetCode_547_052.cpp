class Solution {
public:
    //sol1: use BFS
    int n;
    vector<int> visited;
    
    void BFS(int node,vector<vector<int>>& M){
        queue<int> q;
        q.push(node);
        
        while(!q.empty()){
            int newNode=q.front();q.pop(); 
            visited[newNode]=1;
            //for every neighbor of node
            for(int j=0;j<n; j++)
                if(M[newNode][j]==1 && visited[j]==0)
                    q.push(j);
        }
    }
    
    int findCircleNum(vector<vector<int>>& M) {
        n=M.size();
        visited.resize(n);
        fill(visited.begin(), visited.end(), 0);
        
        int count=0;
        for(int i=0; i<n; i++){
            if(visited[i]==0){
                count++;
                BFS(i,M);
            }
                
        }
        cout<<count<<endl;
        return count;
    }
    
    //sol2: use set operations....to be done in the future
    
    
};