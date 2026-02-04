class Solution {
    public boolean isVowel(char curr){
        if(curr=='a' || curr=='e' ||  curr=='i' ||  curr=='o' || curr=='u') return true;
        return false;
    }
    public int maxVowels(String s, int k) {
        int start = 0;
        int end = 0;
        int currCount = 0;
        int maxCount = 0;
        while (end < s.length()){
            char curr =s.charAt(end);
            if (isVowel(curr)) currCount++;
            if (end >= k-1){
                maxCount = Math.max(currCount,maxCount);
                char exclude = s.charAt(start);
                if (isVowel(exclude)) currCount--;
                start++;
            }
            end++;
        }
        return maxCount;
    }
}