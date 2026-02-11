class Solution {
    class Pair{
        int row ;
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
    int rowD[] = {-1,0,0,1};
    int colD[] = {0,1,-1,0};
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int or = image[sr][sc];
        if (or==color) return image;
        Queue<Pair> q = new LinkedList<>(); 
        int n = image.length;
        int m = image[0].length;
        boolean isVis[][] = new boolean[n][m];
        q.add(new Pair(sr,sc));
        isVis[sr][sc] = true;
        while (!q.isEmpty()){
            Pair curr = q.poll();
            int currRow = curr.row;
            int currCol = curr.col;
            image[currRow][currCol] = color;
            for (int i=0; i<4;i++){
                int newRow = currRow + rowD[i];
                int newCol = currCol +colD[i];
                if (isValid(newRow, newCol, n,m) && image[newRow][newCol]==or && isVis[newRow][newCol]==false){
                    isVis[newRow][newCol] = true;
                    q.add(new Pair(newRow,newCol));
                }
            }
        }
        return image;
    }
}