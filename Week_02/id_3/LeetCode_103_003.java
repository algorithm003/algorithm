package com.zzm;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author zhongzuoming <zhongzuoming, 1299076979@qq.com>
 * @version v1.0
 * @Description baipao
 * @encoding UTF-8
 * @date 2019-06-30
 * @time 13:04
 * @修改记录 <pre>
 * 版本       修改人         修改时间         修改内容描述
 * --------------------------------------------------
 * <p>
 * --------------------------------------------------
 * </pre>
 */
public class LeetCode_103_003 {


    public static  List<List<Integer>> zigzagLevelOrder(TreeNode root) {

        List<List<Integer>> res = new ArrayList<>();
        helper(res,root,0);

        return res;
    }

    public static void helper(List<List<Integer>> res, TreeNode root, int depth) {

        if (null == root){
            return;
        }

        if (depth == res.size()){
            res.add(new ArrayList());
        }
        if (depth % 2 == 0) {
            res.get(depth).add(root.val);
        }else {
            res.get(depth).add(0,root.val);
        }

        helper(res,root.left,depth++);
        helper(res,root.right,depth++);
    }

}
