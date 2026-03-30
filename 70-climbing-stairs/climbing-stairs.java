class Solution {
    /*public int dp[];
    public int solve(int n){
        if(dp[n]!= -1) return dp[n];
        if(n==1 || n==2 ) return n;
        return dp[n] = solve(n-1) + solve(n-2);
    }
    public int climbStairs(int n) {
        dp = new int[n+1];
        Arrays.fill(dp,-1);
        return solve(n);
    }*/
    public int[] dp;
    public int climbStairs(int n){
        dp = new int[n+2];
        Arrays.fill(dp,-1);
        return solve(0,n);
    }
    public int solve(int i, int n){
        if(i==n) return 1;
        if(i>n) return 0;
        if(dp[i] !=-1) return dp[i];
        return dp[i]= solve(i+1,n) + solve(i+2,n);
    }
}