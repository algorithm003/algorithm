package algorithm.Week_03.id_50;

import java.util.*;

/**
 * Created by yu on 2019/7/7.
 * 最小高度树
 */
public class LeetCode_310_050 {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if (n == 1) {
            return Collections.singletonList(0);
        }
        List<Set<Integer>> obj = new ArrayList<>(n);
        for (int i = 0; i < n; ++i) {
            obj.add(new HashSet<>());
        }
        for (int[] edge : edges) {
            obj.get(edge[0]).add(edge[1]);
            obj.get(edge[1]).add(edge[0]);
        }
        List<Integer> resultList = new ArrayList<>();
        for(int i=0;i<n;++i) {
            if (obj.get(i).size() == 1) {
                resultList.add(i);
            }
        }
        while (n > 2) {
            n -= resultList.size();
            List<Integer> tmpList = new ArrayList<>();
            for (int i : resultList) {
                int j = obj.get(i).iterator().next();
                obj.get(j).remove(i);
                if (obj.get(j).size() == 1) {
                    tmpList.add(j);
                }
            }
            resultList = tmpList;
        }
        return  resultList;
    }
}
