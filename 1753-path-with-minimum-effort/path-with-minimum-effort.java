class Solution {
    class Pair{
        int row;
        int col;
        int effort;
        Pair(int row,int col, int effort ){
            this.row = row;
            this.col =col;
            this.effort = effort;
        }
    }
    public int minimumEffortPath(int[][] heights) {
        int n = heights.length;
        int m = heights[0].length;
        int[][] dis = new int[n][m];
        for (int[] i : dis){
            Arrays.fill(i,Integer.MAX_VALUE);
        }
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b)-> a.effort - b.effort);
        pq.add(new Pair(0,0,0));
        dis[0][0]=0;
        int[] rd = {-1,1,0,0};
        int[] cd = {0,0,-1,1};
        while (!pq.isEmpty()){
            Pair curr = pq.poll();
            int cr = curr.row;
            int cc = curr.col;
            int ce = curr.effort;
            if (cr==n-1 && cc == m-1){
                return ce;
            }
            for (int i=0; i<4;i++){
                int nr = cr + rd[i];
                int nc = cc + cd[i];
                if (nr>=0 && nr <n && nc>=0 && nc<m){
                    int newEffort = Math.max(ce,Math.abs(heights[nr][nc]-heights[cr][cc]));
                    if (newEffort < dis[nr][nc]){
                        dis[nr][nc] = newEffort;
                        pq.add(new Pair(nr,nc,newEffort));
                    }
                }
            }
        }
        return 0;
    }
}