class Solution {
    int n;
    public int findCircleNum(int[][] isConnected) {
        n = isConnected.length;
        boolean[] vis = new boolean[n];
        int count=0;
        for(int i=0;i<n;i++){
            if(!vis[i]){
                dfs(i,vis, isConnected);
                count++;
            }            
        }
        return count;
    }
    public void dfs(int u, boolean[] vis, int[][] isConnected){
        vis[u] = true;
        for(int v=0; v<n;v++){
            if(!vis[v] && isConnected[u][v]==1) dfs(v,vis,isConnected);
        }
    }
}