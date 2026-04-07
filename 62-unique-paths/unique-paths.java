class Solution {
    public Integer[][] dp;
    public int uniquePaths(int m, int n) {
        dp = new Integer[m][n];
        
        return tab(0,0,m,n);
    }
    public int tab(int i,int j,int m,int n){
        if(i>=m || j>=n) return 0;
        if(i==m-1 && j==n-1) return 1; 
        if(dp[i][j]!= null) return dp[i][j];
        int right = tab(i,j+1,m,n);
        int down = tab(i+1,j,m,n);
        return dp[i][j]=right+down;
    }
}