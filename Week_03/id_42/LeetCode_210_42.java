import java.util.ArrayList;

public class LeetCode_210_42 {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<Integer>());
        }
        for (int i = 0; i < prerequisites.length; i++) {
            int course = prerequisites[i][0];
            int pcourse = prerequisites[i][1];
            graph.get(course).add(pcourse);
        }
        int[] visited = new int[numCourses];
//        List<Integer> ret = new ArrayList<Integer>();
        int[] ret = new int[numCourses];
        for (int i = 0; i < numCourses; i++)
            if (DFS2(i, graph, visited, ret))
                return new int[0];
        return ret;
    }


    public boolean DFS(int curr, ArrayList<ArrayList<Integer>> graph, int[] visited, int[] ret) {
        //回路，有环
        if (visited[curr] == 1) return true;
        //从该点出发没有回路
        if (visited[curr] == -1) return false;
        //首次访问
        visited[curr] = 1;
        for (int id : graph.get(curr)) {
            if (DFS(id, graph, visited, ret)) {
                return true; //无回路
            }
        }
        ret[curr] = curr;
        visited[curr] = -1;//从该点出发没有回路
        return false;
    }

}
