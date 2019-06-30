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
public class LeetCode_98_003 {

   private static TreeNode pre = null;

    public static boolean isValidBST(TreeNode root) {
        if(null == root) {
            return true;
        }
        if (!isValidBST(root.left)){
            return false;
        }

        if (null != pre && pre.val >= root.val ){
            return false;
        }
        pre = root;
        return isValidBST(root.right);
    }


}
