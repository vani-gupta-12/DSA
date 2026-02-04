class Solution {
    public double findMaxAverage(int[] nums, int k) {
        /*int curr = 0;
        int max = Integer.MIN_VALUE;
        for (int i=0; i<k; i++){
            for (int j=0; j<k; j++){
                curr += 
            }
        }*/
        int start = 0;
        int end = 0;
        int curr = 0;
        int maxSum = Integer.MIN_VALUE;
        while(end<nums.length){
            curr += nums[end];
            if (end >= k-1){
                maxSum = Math.max(curr, maxSum);
                curr -=nums[start];
                start++;
            }
            end++;
        }
        return (double) maxSum/k;
    }
}