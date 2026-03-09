class Solution {
    class DSU{
        int[] parent;
        DSU(int n){
            parent = new int[n];
            for (int i=0; i<n;i++){
                parent[i] = i;
            }
        }
        public boolean union(int a, int b){
            int pa = find(a);
            int pb = find(b);
            if (pa != pb) parent[pb] = pa;
            if (pa==pb) return true;
            return false;
        }
        public int find(int x){
            if (parent[x]==x) return x;
            return parent[x] = find(parent[x]);
        }
    }
    public int[] findRedundantConnection(int[][] edges) {
        DSU obj = new DSU(edges.length+1);
        for (int[] i : edges){
            int u = i[0];
            int v = i[1];
            if (obj.union(u,v)) return i;
        }
        return new int[]{};
    }
}