class Solution {
    public int firstUniqChar(String s) {
        HashMap<Character, Integer> mp = new HashMap<>();
        for(char c : s.toCharArray()){
            mp.put(c,mp.getOrDefault(c,0)+1);
        }
        for(int i=0; i<s.length();i++){
            char curr = s.charAt(i);
            if(mp.get(curr)==1){
                return i;
            }
        }
        return -1;
    }
}