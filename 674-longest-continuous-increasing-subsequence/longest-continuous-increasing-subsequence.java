class Solution {
    public int findLengthOfLCIS(int[] nums) {
        if(nums.length==0) return 0;
        int maxV = 1;
        int count = 1;
        for (int i=0; i<nums.length-1; i++){
            if (nums[i] < nums[i+1]){
                count++;
                maxV = Math.max(count, maxV);
            }
            else count = 1;
        }
        return maxV;
    }
}