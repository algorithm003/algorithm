package com.panguang.cooltea.pglib;
import java.util.ArrayList;
import java.util.List;

/*
*
*        784. 字母大小写全排列
*
*        给定一个字符串S，通过将字符串S中的每个字母转变大小写，我们可以获得一个新的字符串。返回所有可能得到的字符串集合。
*        示例:
*        输入: S = "a1b2"
*        输出: ["a1b2", "a1B2", "A1b2", "A1B2"]
*
*        输入: S = "3z4"
*        输出: ["3z4", "3Z4"]
*
*        输入: S = "12345"
*        输出: ["12345"]
*
*        注意：
*        S 的长度不超过12。
*        S 仅由数字和字母组成。
*
*        链接：https://leetcode-cn.com/problems/letter-case-permutation
*
*        学号：020
*
*/

public class LeetCode_784_20 {

    //方法一： DFS
    //时间复杂度：O(2^n)
    //空间复杂度：O(n)
    public List<String> letterCasePermutation(String S) {
        List<String> result = new ArrayList<String>();
        letterCase(result, S.toCharArray(), 0);
        return result;
    }

    private void letterCase(List<String> result, char[] soure, int index){
        if (index == soure.length){
            result.add(new String(soure));
        }else{

//            if (Character.isLetter(soure[index])){
//                soure[index] = Character.toLowerCase(soure[index]);
//                letterCase(result, soure, index + 1);
//                soure[index] = Character.toUpperCase(soure[index]);
//            }
//            letterCase(result, soure, index + 1);

            letterCase(result, soure, index + 1);
            if (Character.isLetter(soure[index])){
                soure[index] ^= (1 << 5);
                letterCase(result, soure, index + 1);
            }

        }
    }

}
