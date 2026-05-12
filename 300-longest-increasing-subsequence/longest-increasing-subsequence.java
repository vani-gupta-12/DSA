class Solution {
    int[][] dp;
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        dp = new int[n+1][n+1];
        int take = 0;
        int skip;
        for (int i=n-1;i>=0;i--){
            for(int j=i-1;j>=-1;j--){
                take = 0;
                skip = 0 + dp[i+1][j+1];
                if(j==-1|| nums[i] > nums[j]) take = 1 + dp[i+1][i+1];
                dp[i][j+1] = Math.max(skip, take); 
            }
        }
        return dp[0][0];
    }
}