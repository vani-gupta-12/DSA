class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int start = 0;
        int end = 0;
        int count = 0;
        int curr =1;
        if (k<=1) return 0;
        while (end < nums.length){
            curr *= nums[end];
            while (start <= end && curr >=k){
                curr/= nums[start];
                start++;
            }
            count += end -start +1;
            end++;
        }
        return count;
    }
}