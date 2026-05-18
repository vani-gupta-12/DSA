class Solution {
    class Pair{
        int row;
        int col;
        Pair(int row, int col){
            this.row = row;
            this.col = col;
        }
    }
    int[] rd = {0,0,-1,1};
    int[] cd = {1,-1,0,0};
    public int[][] updateMatrix(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        boolean[][] vis = new boolean[n][m];
        Queue<Pair> q = new LinkedList<>();
        int ans[][] = new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0; j<m;j++){
                if(mat[i][j] == 0){
                    q.add(new Pair(i,j));
                    vis[i][j] = true;
                    ans[i][j] = 0;
                }
            }
        }
        while(!q.isEmpty()){
            Pair curr = q.poll();
            int cr = curr.row;
            int cc = curr.col;
            for(int i=0; i<4;i++){
                int nr = cr + rd[i];
                int nc = cc + cd[i];
                if(nr<n && nr>=0 && nc<m && nc>=0 && mat[nr][nc]==1 && !vis[nr][nc]){
                    q.add(new Pair(nr,nc));
                    vis[nr][nc]=true;
                    ans[nr][nc] = ans[cr][cc]+1;
                }
            }
        }
        return ans;
    }
}