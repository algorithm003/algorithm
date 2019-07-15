package others;


import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @Auther hantao on 2019/7/14.
 * @Date 2019/7/14 23:01
 * @Description
 */
public class LeetCode_784_13 {
    // BFS
    public List<String> letterCasePermutation_BFS(String s) {
        if (s == null ){
            return null;
        }

        Queue<String> queue = new LinkedList<String>();
        queue.offer(s);

        for (int i =0;i < s.length();i++){
            if (Character.isDigit(s.charAt(i))) continue;

            int size = queue.size();
            for (int j = 0;j < size;j++){
                String cur = queue.poll();
                char[] chs = cur.toCharArray();

                chs[i] = Character.toUpperCase(chs[i]);
                queue.offer(String.valueOf(chs));

                chs[i] = Character.toLowerCase(chs[i]);
                queue.offer(String.valueOf(chs));

            }
        }

        return new LinkedList<String>(queue);

    }


    // DFS
    public List<String> letterCasePermutation_DFS(String s) {

        if (s == null){
            return null;
        }

        List<String> res = new LinkedList<String>();
        dfs(0,res,s);
        return res;

    }

    private void dfs(int i, List<String> res, String s) {
        // termentor 此处终止条件非 i == s.length()-1
        if (i == s.length()){
            res.add(s);
            return;
        }

        if (Character.isDigit(s.charAt(i))){
            dfs(i+1,res,s);
        } else {
            char[] chs = s.toCharArray();
            chs[i] = Character.toUpperCase(chs[i]);
            dfs(i+1,res,String.valueOf(chs));

            chs[i] = Character.toLowerCase(chs[i]);
            dfs(i+1,res,String.valueOf(chs));
        }

    }


    public static void main(String[] args){

        Queue<String> queue = new LinkedList<String>();
        String s = "abc123";
        System.out.println(new LeetCode_784_13().letterCasePermutation_BFS(s));
        System.out.println(new LeetCode_784_13().letterCasePermutation_DFS(s));

    }
}
