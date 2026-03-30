class Solution {
    public int[] dp;
    public int tribonacci(int n) {
        dp = new int[n+1];
        Arrays.fill(dp , -1);
        return fib(n);
    }
    public int fib(int n){
        if(dp[n]!=-1) return dp[n];
        if(n==0) return n;
        if(n==2 || n==1) return 1;
        return dp[n] = fib(n-1)+fib(n-2)+fib(n-3);
    }
}