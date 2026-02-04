class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int n = nums.length;
        int start = 0;
        int sum = 0;
        int minValue = Integer.MAX_VALUE;
        for (int end=0; end<n; end++){
            sum += nums[end];
            while(sum >= target){
                minValue = Math.min(minValue,end-start+1);
                sum -= nums[start];
                start++;
            }
        }
        return minValue == Integer.MAX_VALUE ? 0 : minValue;
    }
}