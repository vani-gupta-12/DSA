class Solution {
    int[][] dp;
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        dp = new int[n][n+1];
        for (int i=n-1;i>=0;i--){
            for(int j=0;j<=i;j++){
                dp[i][j] = -1;
            }
        }
        return solve(nums, 0, -1);
    }
    public int solve(int[] nums, int i , int prev){
        if(i>=nums.length) return 0;
        if(dp[i][prev+1] != -1) return dp[i][prev+1];
        int take = 0;
        if(prev == -1 || nums[i] > nums[prev]) take = 1+solve(nums,i+1,i);
        int skip = solve(nums,i+1,prev);
        return dp[i][prev+1]= Math.max(take , skip);
    }
}