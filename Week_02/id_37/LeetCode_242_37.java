package Week_02.id_37;

/**
 * 类描述：242. 有效的字母异位词
 * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
 * 创建人： Sun YongMeng
 * 创建时间：2019/6/24 18:05
 * 修改人：  Sun YongMeng
 * 修改时间：2019/6/24 18:05
 * 修改备注：
 */
public class LeetCode_242_37 {
    /**
     * 242. 有效的字母异位词
     * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
     * @param s
     * @param t
     * @return
     */
    public boolean leetCode_242(String s, String t) {
        /**
         * 题解:用哈希表
         * 一个加,一个减;最后遍历不为0则不相同
         */
        if(s.length() != t.length()){ return false;}
        int[] alpha = new int[26];
        for(int i = 0; i < s.length(); i ++) {
            alpha[s.charAt(i) - 'a'] ++;
            alpha[t.charAt(i) - 'a'] --;
        }
        for(int i = 0;i< 26; i ++) {
            if (alpha[i] != 0){return false;}
        }
        return true;
    }
}
