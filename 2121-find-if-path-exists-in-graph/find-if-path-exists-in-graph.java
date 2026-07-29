class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        if(source==destination) return true;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i=0; i<n;i++) adj.add(new ArrayList<>());
        for(int i=0; i<edges.length;i++){
            int u = edges[i][0];
            int v = edges[i][1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        Queue<Integer> q = new LinkedList<>();
        boolean[] vis = new boolean[adj.size()];
        vis[source] = true;
        q.add(source);
        while(!q.isEmpty()){
            int curr = q.poll();
            for(int neigh : adj.get(curr)){
                if(!vis[neigh]){
                    if(neigh==destination) return true;
                    q.add(neigh);
                    vis[neigh] = true;
                }
            }
        }   
        return false;
    }
}