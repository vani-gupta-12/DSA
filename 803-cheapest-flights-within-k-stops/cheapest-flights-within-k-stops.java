class Solution {
    class Pair{
        int city;
        int cost;
        int stop;
     Pair(int c, int co, int s) {
            this.city = c;
            this.cost = co;
            this.stop = s;
            
        }
    }
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        ArrayList<int[]> [] adj = new ArrayList[n];
        for(int  i=0;i<n;i++){
            adj[i]=new ArrayList<>();
        }
        for(int[] f : flights){
            adj[f[0]].add(new int[]{f[1],f[2]});
        }

        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b) -> a.cost - b.cost);
        pq.add(new Pair(src,0,0));

        int[] stopArr = new int[n];
        Arrays.fill(stopArr,Integer.MAX_VALUE);

        while(!pq.isEmpty()){
            Pair curr = pq.poll();
            int city = curr.city;
            int cost = curr.cost;
            int stops = curr.stop;

            if (city == dst) return cost;

            if (stops > k) continue;

            if (stops > stopArr[city]) continue;

            stopArr[city] = stops;
            for (int[] next : adj[city]) {
                pq.offer(new Pair(
                        next[0],
                        cost + next[1],
                        stops + 1
                ));
            }
        }
    
        return -1;
        
        
    }
}