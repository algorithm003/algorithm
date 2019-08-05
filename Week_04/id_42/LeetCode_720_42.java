public class LeetCode_720_42 {
    public String longestWord(String[] words) {
        Arrays.sort(words);
        Set<String> set = new HashSet<>();
        String res = "";
        for (String word : words) {
            int len = word.length();
            if (len == 1 || set.contains(word.substring(0, len - 1))) {
                res = len > res.length() ? word : res;
                set.add(word);
            }
        }
        return res;
    }

    @Test
    public void test() {
        String[] words = {"a", "banana", "app", "appl", "ap", "apply","apply3", "apple"};
        String res = longestWord(words);
        System.out.println(res);
    }
}
