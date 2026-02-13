class Solution {
    class Pair{
        int row ;
        int col;
        Pair(int row, int col){
            this.row = row;
            this.col = col;
        }
    }
    int[] rd  = {-1,1,0,0};
    int[] cd = {0,0,1,-1};
    public int[][] updateMatrix(int[][] mat) {
        int n =mat.length;
        int m = mat[0].length;
        Queue<Pair> q = new LinkedList<>();
        int[][] ans = new int[n][m];
        boolean[][] vis = new boolean[n][m];
        for (int i=0;i<n;i++){
            for (int j=0; j<m;j++){
                if (mat[i][j]==0){
                    vis[i][j]= true;
                    q.add(new Pair(i,j));
                    ans[i][j]=0;
                }
            }
        
        }
        while (!q.isEmpty()){
            Pair curr = q.poll();
            int cr = curr.row;
            int cc = curr.col;
            for (int i=0; i<4;i++){
                int nr = cr + rd[i];
                int nc = cc + cd[i];
                if (nr>=0 && nr<n && nc>=0 && nc<m && mat[nr][nc]==1 && !vis[nr][nc]){
                    vis[nr][nc] = true;
                    ans[nr][nc] = ans[cr][cc]+ 1;
                    q.add(new Pair(nr,nc));
                }
            }
        }
        return ans;
    }
}