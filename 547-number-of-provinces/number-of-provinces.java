class Solution {
    public void bfs(int start, boolean isVis[],ArrayList<ArrayList<Integer>> adj ){
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        isVis[start]=true;
        while (!q.isEmpty()){
            int curr = q.poll();
            for (int i=0; i<adj.get(curr).size();i++){
                int neigh = adj.get(curr).get(i);
                if (isVis[neigh]==false){
                    isVis[neigh]= true;
                    q.add(neigh);
                }
            }
        }
    }
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i= 0; i<n; i++) adj.add(new ArrayList<>());
        for (int i=0; i<n;i++){
            for (int j =0;j<n;j++){
                if (isConnected[i][j] == 1){
                    int from =i;
                    int to=j;
                    adj.get(from).add(to);
                }
            }
        }
        int count = 0;
        boolean isVis[] = new boolean[n];
        for (int i=0;i<isVis.length;i++){
            if(isVis[i]==false){
                count++;
                bfs(i,isVis,adj);
            }
        }
        return count;
    }
}