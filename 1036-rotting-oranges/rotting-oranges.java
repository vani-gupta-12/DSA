class Solution {
    class Pair{
        int row;
        int col;
        Pair(int row, int col){
            this.row = row;
            this.col = col;
        }
    }
    int[] rowD = {-1,0,0,1};
    int[] colD = {0,1,-1,0};
    public int orangesRotting(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        Queue<Pair> q = new LinkedList<>();
        boolean[][] Vis = new boolean[n][m];
        int fresh = 0;
        for (int i=0; i<n; i++){
            for (int j=0; j<m;j++){
                if (grid[i][j]==2){
                    q.add(new Pair(i,j));
                    Vis[i][j] = true;
                } else if (grid[i][j] == 1) fresh++;
            }
        }
        int time = 0;
        while (!q.isEmpty()){
            int size = q.size();
            boolean flag = false;
            while (size!=0){
                size--;
                Pair curr = q.poll();
                int currRow = curr.row;
                int currCol = curr.col;
                for (int i=0; i<4;i++){
                    int newR = currRow + rowD[i];
                    int newC = currCol + colD[i];
                    if (newR>=0 && newR <n && newC>=0 && newC<m && grid[newR][newC]==1 && !Vis[newR][newC]){
                        flag = true;
                        fresh--;
                        Vis[newR][newC] = true;
                        q.add(new Pair(newR,newC));
                    }
                }
            }
            if (flag== true) time++;
        }
        if (fresh!= 0) return -1;
        return time;
    }
}