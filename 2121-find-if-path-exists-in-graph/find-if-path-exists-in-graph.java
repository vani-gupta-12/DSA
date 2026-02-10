class Solution {
    public boolean dfs(int n,int source, ArrayList<Integer> ans, boolean[] isVis, int destination,ArrayList<ArrayList<Integer>> adj, int[][] edges){
        if (source == destination) return true;
        isVis[source]=true;
        for (int i=0;i<adj.get(source).size();i++){
            int neigh = adj.get(source).get(i);
            if (neigh == destination) return true;
            if (isVis[neigh]==false){
                if (dfs(n, neigh, ans, isVis, destination, adj, edges))
                return true;
            }
        }
        return false;
    }
    public boolean validPath(int n, int[][] edges, int source, int destination) {
    //BFS
        /*if (source == destination) return true;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();
       
        for (int i=0; i<n;i++){
            adj.add(new ArrayList<>());
        }
        for (int i= 0; i<edges.length;i++){
            int from = edges[i][0];
            int to = edges[i][1];
            adj.get(from).add(to);
            adj.get(to).add(from);
        }
        boolean isVis[] = new boolean[adj.size()];
        q.add(source);
        isVis[source] = true;
        while (!q.isEmpty()){
            int curr = q.poll();
            for (int i=0; i<adj.get(curr).size();i++){
                int neighbour = adj.get(curr).get(i);
                if (neighbour == destination) return true;
                if (isVis[neighbour]==false){
                    isVis[neighbour]=true;
                    q.add(neighbour);
                }
            }
        }
        return false;*/

//DFS
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i=0;i<n;i++) adj.add(new ArrayList<>());
        for (int i=0;i<edges.length;i++){
            int u = edges[i][0];
            int v = edges[i][1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        ArrayList<Integer> ans = new ArrayList<>();
        int a = adj.size();
        boolean[] isVis = new boolean[a];
        return dfs(n,source,ans, isVis, destination, adj, edges);
    }
}