class Solution {
    public boolean isPalindrome(String s) {
        s= s.replaceAll("[^a-zA-Z0-9]","").toLowerCase();
        return pal(s,0);
    }
    public boolean pal(String s, int i){
        if (i >= s.length()/2) return true;
        if (s.charAt(i) != s.charAt(s.length()-i-1)) return false;
        return pal(s, i+1);
    }
}