class Solution {
    public int majorityElement(int[] nums) {
        int n = nums.length;
        HashMap<Integer, Integer> mp = new HashMap<>();
        for(int x : nums){
            mp.put(x, mp.getOrDefault(x ,0)+1);
            if(mp.get(x) > n/2) return x;
        }
        return -1;

    }
}