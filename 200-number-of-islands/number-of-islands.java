class Solution {
    int n;
    int m;
    public int numIslands(char[][] grid) {
        n = grid.length;
        m= grid[0].length;
        int count = 0;
        boolean[][] vis = new boolean[n][m];
        for(int i=0; i<n;i++){
            for(int j=0; j<m;j++){
                if(grid[i][j]=='1' && !vis[i][j]){
                    dfs(i,j, vis, grid);
                    count++;
                }
            }
            
        }
        return count;
    }
    public void dfs(int i,int j, boolean[][] vis, char[][] grid){
        if(i>=n || i<0 || j<0 || j>=m || grid[i][j]=='0' || vis[i][j]) return;
        vis[i][j] = true;
        dfs(i+1,j,vis, grid);
        dfs(i-1,j,vis,grid);
        dfs(i,j-1, vis, grid);
        dfs(i,j+1, vis,grid);
    }
}