class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        if (source == destination) return true;
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
        return false;
    }
}