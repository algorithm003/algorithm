import java.util.ArrayList;
import java.util.List;

public class LeetCode_784_16 {
    public List<String> letterCasePermutation(String S) {
        if (S == null || S.length() == 0) {
            return new ArrayList<String>();
        }

        ArrayList<String> res = new ArrayList<String>();
        backtrace(S.toCharArray(), 0, res);
        return res;
    }

    public void backtrace(char[] currentChar, int index, ArrayList<String> strs) {
        if (index == currentChar.length) {
            strs.add(String.valueOf(currentChar));
            return;
        }

        if (Character.isAlphabetic(currentChar[index])) {
            char alph = currentChar[index];
            currentChar[index] = Character.toLowerCase(alph);
            backtrace(currentChar, index + 1, strs);
            currentChar[index] = Character.toUpperCase(alph);
            backtrace(currentChar, index + 1, strs);
        }
        else {
            backtrace(currentChar, index + 1, strs);
        }
    }
}
