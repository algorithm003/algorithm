class Solution {
public:
  //
  // 
  //
  //  
 //sol3: simple and neat solution to keep record for the indegree of each node,
  //     First find nodes with indegree 0, then remove that node from the graph.
    //   This becomes a smaller problem so iterate this process until no nodes with 0 
    //   indegree exists.
    //   Time complexity: O(N + E) 
    vector<int> findOrder(int numCourses, vector<vector<int>>& prerequisites) {
        vector<int> result;
        vector<int> ind;
        vector< vector<int> >adj (numCourses);
        queue<int> q;
        
        for(int i=0; i<numCourses; i++)
            ind.push_back(0);
                
        //build up adj list
        for(int i=0; i<prerequisites.size(); i++){
        //for every pair
            vector<int> pair=prerequisites[i];
            adj[pair[1]].push_back(pair[0]);
            ind[pair[0]]++;
        }
        
        //find out all nodes with indegree ==0 and push them into q        
        for(int i=0; i<numCourses; i++){
            if(ind[i]==0)   q.push(i);
        }
        while(!q.empty()){
            int node = q.front(); q.pop();
            result.push_back(node);
            //for every neighbor of node:
            for(int i=0; i<adj[node].size(); i++){
                int neighbor= adj[node][i];
                ind[neighbor]--;
                if(ind[neighbor]==0)
                    q.push(neighbor);
            }
        }
        
        if(result.size()!=numCourses){
            vector<int> empt;
            return empt;
        }
            
        for(int i=0; i<result.size(); i++){
            cout<<result[i]<<endl;
        }
        return result;
        
    }   
    /*
    Why does the indegree solution has less code than the traditional graph solution?
    Because there are a lot of set up for the the traditional graph solution.
    
    */
    
   //sol1
   /*
  int WHITE = 1;
  int GRAY = 2;
  int BLACK = 3;

  bool isPossible;
  map<int, int> color;
  map<int, vector<int>> adjList;
  vector<int> topologicalOrder;

   void init(int numCourses) {
    isPossible = true;
   
    // By default all vertces are WHITE
    for (int i = 0; i < numCourses; i++) {
      color[i]= WHITE;
    }
  }

   void dfs(int node) {

    // Don't recurse further if we found a cycle already
    if (!isPossible) {
      return;
    }

    // Start the recursion
    color[node]= GRAY;

    // Traverse on neighboring vertices
    //for (Integer neighbor : this.adjList.getOrDefault(node, new ArrayList<Integer>())) {
      for(int i=0; i<adjList[node].size(); i++){
         int neighbor=adjList[node][i];
          if (color[neighbor] == WHITE) {
            dfs(neighbor);
          } else if (color[neighbor] == GRAY) {
            // An edge to a GRAY vertex represents a cycle
            isPossible = false;
          }
    }

    // Recursion ends. We mark it as black
    color[node]= BLACK;
    topologicalOrder.push_back(node);
  }

  vector<int> findOrder(int numCourses,  vector<vector<int>>& prerequisites) {

    init(numCourses);

    // Create the adjacency list representation of the graph
    for (int i = 0; i < prerequisites.size(); i++) {
      int dest = prerequisites[i][0];
      int src = prerequisites[i][1];
      //List<Integer> lst = adjList.getOrDefault(src, new ArrayList<Integer>());
      //lst.add(dest);
      adjList[src].push_back( dest );
    }

    // If the node is unprocessed, then call dfs on it.
    for (int i = 0; i < numCourses; i++) {
      if (color[i] == WHITE) {
        dfs(i);
      }
    }

    vector<int> order;
    if (isPossible) {
      order.resize(numCourses);
      for (int i = 0; i < numCourses; i++) {
        order[i] = topologicalOrder[numCourses - i - 1];
      }
    } else {
     // order = new int[0];
    }

    return order;
  }

    
    */
        
    //sol2
    /*
    vector<int> level;
    set<int> visited;
     vector< vector<int> >adj;
    
    void BFS(int node){
        queue<int> q;

        q.push(node);
        level[node]=0;
        
        while(!q.empty()){
            int node=q.front();q.pop();
            visited.insert(node);
            
            for(int i=0; i<adj[node].size(); i++){
                int child = adj[node][0];
                if(visited.count(child))
                    return ;
                q.push(child);
                level[child] = level[node]+1;
            }
            
        }
        
        
    }
    
    
    vector<int> findOrder(int numCourses, vector<vector<int>>& prerequisites) {
     
        level.resize(numCourses);
        for(int i=0; i<numCourses; i++)
            level[i]=-1;

        set<int> pointedNodes;
        adj.resize(numCourses);
       
        for(int i=0; i<prerequisites.size(); i++){
            //for every pair
            vector<int> pair=prerequisites[i];
            adj[pair[1]].push_back(pair[0]);
            pointedNodes.insert(pair[0]);
        }
        
        //find nodes without incoming edges and BFS them
        for(int i=0; i<numCourses; i++){
            if( pointedNodes.count(i) )
                BFS(i);
        }
        
        
        vector<int> r;

        for(int l=0;l<numCourses; l++){
            for(int j=0;j<level.size(); j++){
                 if(level[j]==l){
                     r.push_back(j);
                     cout<<j<<endl;
                     
                 }
            }
        }
            
        return r;
    }
    */
};