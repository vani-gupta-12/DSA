class Solution {
    class DSU{
        int[] parent;
        int[] rank;
        DSU(int n){
            parent = new int[n];
            rank = new int[n];
            for (int i=0 ;i<n;i++){
                parent[i]= i;
                rank[i] = 0;
            }
        }
        public void union(int a, int b){
            int pa = find(a);
            int pb = find(b);
            if (pa == pb) return;
            if (rank[pa]>rank[pb]) parent[pb] = pa;
            else if (rank[pb]> rank[pa]) parent[pa] = pb;
            else{
                parent[pb] =pa;
                rank[pa]++;
            }
        }
        public int find(int x){
            if (parent[x]==x) return x;
            return parent[x] = find(parent[x]);
        }
    }
    public int removeStones(int[][] stones) {
        DSU obj = new DSU(stones.length);
        for (int i=0; i<stones.length; i++){
            int row = stones[i][0];
            int col = stones[i][1];
            for (int j=i+1; j<stones.length;j++){
                int cr = stones[j][0];
                int cc = stones[j][1];
                if (cr==row || cc == col) obj.union(i,j);
            }
        }
        HashSet<Integer> set = new HashSet<>();
        for (int i=0; i<stones.length;i++){
            set.add(obj.find(i));
        }
        return stones.length-set.size();
    }
}