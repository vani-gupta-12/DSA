class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int count = 0;
        int maxValue = Integer.MIN_VALUE;
        for (int i=0; i<nums.length; i++){
            if (nums[i]==1){
                count++;
            }else {
                count = 0;
            }
            maxValue = Math.max(maxValue, count);
        }
        return maxValue;
    }
}