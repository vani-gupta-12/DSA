class Solution {
    class pair{
        int node;
        double dis;
        pair(int node, double dis){
            this.node = node;
            this.dis = dis;
        }
    }
    public double maxProbability(int n, int[][] edges, double[] succProb, int start_node, int end_node) {
        ArrayList<ArrayList<pair>> adj = new ArrayList<>();
        for (int i=0;i<n;i++) adj.add(new ArrayList<>());
        double[] ans = new double[n];
        ans[start_node] = 1;
        for (int i=0; i<edges.length; i++){
            int u=edges[i][0];
            int v= edges[i][1];
            double w = succProb[i];
            adj.get(u).add(new pair(v,w));
            adj.get(v).add(new pair(u,w));
        }
        PriorityQueue<pair> pq = new PriorityQueue<>((a,b) -> Double.compare(b.dis,a.dis));
        pq.add(new pair(start_node,1));
        while (!pq.isEmpty()){
            pair curr = pq.poll();
            int u = curr.node;
            double w = curr.dis;
            if (ans[u]>w) continue;
            for (pair a : adj.get(u)){
                int v = a.node;
                double z = a.dis;
                if (ans[v] < ans[u]*z){
                    ans[v] = ans[u]*z;
                    pq.add(new pair(v, ans[v]));
                }
            }
        }
        return ans[end_node];
    }
}