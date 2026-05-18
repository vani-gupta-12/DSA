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
    int[] cd = {-1,1,0,0};
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int n = image.length;
        int m = image[0].length;
        boolean vis[][] = new boolean[n][m];
        int original = image[sr][sc];
        if(original==color) return image;
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(sr,sc));
        vis[sr][sc] = true;
        while (!q.isEmpty()){
            Pair curr = q.poll();
            int cr = curr.row;
            int cc = curr.col;
            image[cr][cc] = color;
            for(int i=0; i<4;i++){
                int nr = cr + rd[i];
                int nc = cc + cd[i];
                if(nr>=0 && nr<n && nc>=0 && nc<m && image[nr][nc] == original && !vis[nr][nc]){
                    q.add(new Pair(nr,nc));
                    vis[nr][nc] = true;
                }
            }
            
        }
        return image;
    }
}