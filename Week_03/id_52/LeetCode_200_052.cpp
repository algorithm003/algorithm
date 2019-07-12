class Solution {
public:
    
    
//sol1: 简单的一题但不知为何做起时很多BUG:
// 1. 忘记了GRID所存的是CHAR, 而自己写比较式是用了int, i.e. if(g[i][j]==0)
// 2. 很重要很重要!不要在主程度叫DFS()时之前忘了加一句if( g[i][j]!='0' ) -> 见注釋IMPORTANT
// 3. 在做迷宫相关的题最好把grid print出来方便debug
    
    
    vector<vector<char>> g;
    int m,n;
    void DFS(int i, int j){
       // cout<<"dfs ing"<<endl;
        if( i>=0 && j>=0 && i<m && j<n && g[i][j]!='0' ){
            //process cell
            g[i][j]='0';
            
            //DFS recursive call
            DFS(i-1,j );
            DFS(i+1,j );
            DFS(i,j-1 );
            DFS(i,j+1 );    
        }
    }
    
    int numIslands(vector<vector<char>>& grid) {    
        //For every child
        if(grid.size()==0)
            return 0 ;
        m=grid.size();
        n=grid[0].size();
        
        g.resize(m, vector<char>(n));   //resize 2-d vector

         
        for(int i=0; i<m; i++)
            for(int j=0; j<n ; j++)
                g[i][j]=grid[i][j];
        
        
        int count=0;
        for(int i=0; i<m; i++){
            for(int j=0; j<n ; j++){
                if( g[i][j]!='0' ){         //IMPORTANT
                  DFS(i,j);

                  count++;
                }
            }
        }
        
        
        cout<<count<<endl;
        return count;
    }
};