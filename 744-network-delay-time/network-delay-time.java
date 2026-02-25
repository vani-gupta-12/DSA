class Pair {
    int node;
    int dis;
    Pair(int n, int dis) {
        this.node = n;
        this.dis = dis;
    }
}
class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for (int i = 0; i <= n; i++) adj.add(new ArrayList<>());
        for (int i = 0; i < times.length; i++) {
            int u = times[i][0];
            int v = times[i][1];
            int w = times[i][2];
            adj.get(u).add(new Pair(v, w));
        }
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> Integer.compare(a.dis, b.dis));
        int[] distance = new int[n + 1];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[k] = 0;
        pq.add(new Pair(k, 0));
        while (!pq.isEmpty()) {
            Pair curr = pq.poll();
            int cn = curr.node;
            int cd = curr.dis;
            if (cd > distance[cn]) continue;
            for (Pair neigh : adj.get(cn)) {
                int v = neigh.node;
                int newDis = cd + neigh.dis;

                if (distance[v] > newDis) {
                    distance[v] = newDis;
                    pq.add(new Pair(v, newDis));
                }
            }
        }
        int ans = -1;
        for (int i = 1; i <= n; i++){
            if (distance[i] == Integer.MAX_VALUE) return -1;
            ans= Math.max(ans, distance[i]);
        }
        return ans;    
    }
}