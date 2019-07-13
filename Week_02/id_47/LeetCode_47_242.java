class Solution {
    /**
    /* just use sort and compare
    */
    public boolean isAnagram(String s, String t) {
        
        if(s.length() != t.length()) {
            return false;
        }
        
        char[] sCharArray = s.toCharArray();
        char[] tCharArray = t.toCharArray();
        
        Arrays.sort(sCharArray);
        Arrays.sort(tCharArray);
        
        return Arrays.equals(sCharArray, tCharArray);
    }
}