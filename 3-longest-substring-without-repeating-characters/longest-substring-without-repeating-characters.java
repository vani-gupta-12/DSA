class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int start = 0;
        int end = 0;
        int maxValue = 0;
        HashSet<Character> set = new HashSet<>();
        while (end<n){
            char curr = s.charAt(end);
            if(!set.contains(curr)){
                set.add(curr);
                maxValue = Math.max(maxValue, end - start +1);
                end++;
            }else{
                char temp = s.charAt(start);
                set.remove(temp);
                start++;
            }
        }
        return maxValue;
    }
}