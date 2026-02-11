class Solution {
    class Pair{
        int row;
        int col;
        Pair(int row, int col){
            this.row = row;
            this.col = col;
        }
    }
    public boolean isValid(int row, int col, int tRows, int tCols){
        if (row >=0 && row<tRows && col >= 0 && col<tCols) return true;
        return false;
    }
    int[] rowD ={-1,0,0,1};
    int[] colD = {0,1,-1,0};
    public void bfs(boolean[][] isVis, char[][] grid, int currRow , int currCol, int tRows,int tCols){
        Queue<Pair> q = new LinkedList<>();
        Pair p = new Pair(currRow, currCol);
        q.add(p);
        isVis[currRow][currCol] = true;
        while (!q.isEmpty()){
            Pair curr = q.poll();
            int currPairRow = curr.row;
            int currPairCol = curr.col;
            for (int i=0; i<4;i++){
                int newRow = currPairRow + rowD[i];
                int newCol = currPairCol + colD[i];
                if (isValid(newRow, newCol, tRows, tCols) && grid[newRow][newCol]=='1' && isVis[newRow][newCol]== false){
                    isVis[newRow][newCol]= true;
                    Pair temp = new Pair(newRow, newCol);
                    q.add(temp);
                }
            }
        }
    }
    public int numIslands(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        boolean isVis[][] = new boolean[n][m];
        int count =0;
        for (int i=0;i<n;i++){
            for (int j=0;j<m;j++){
                if (grid[i][j] == '1' && isVis[i][j]==false){
                    count++;
                    bfs(isVis, grid,i,j,n,m);
                }
            }
        }
        return count;
    }
}