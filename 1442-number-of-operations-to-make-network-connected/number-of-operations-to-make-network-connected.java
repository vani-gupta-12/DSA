class Solution {
    int[] parent;
    int[] rank;
    public void DSU(int n ){
        parent = new int[n];
        rank = new int[n];
        for (int i=0; i<n; i++){
            parent[i] = i;
            rank[i] = 0;
        }
    }
    public void union(int a, int b){
        int pa = find(a);
        int pb = find(b);
        if (pa == pb) return;
        if (rank[pa] > rank[pb]) parent[pb] = pa;
        else if (rank[pa] < rank[pb]) parent[pa] = pb;
        else{
            parent[pb]=pa;
            rank[pa]++;
        }
    }
    public int find(int x){
        if (parent[x] == x) return x;
        return parent[x] = find(parent[x]);
    }
    public int makeConnected(int n, int[][] connections) {
        int m = connections.length;
        if (m < n-1) return -1;
        DSU (n);
        for(int[] i : connections){
            int u = i[0];
            int v = i[1];
            union(u,v);
        }
        int count = 0;
        for (int i = 0; i<n;i++){
            if (parent[i]==i) count++;
        }
        return count-1;
    }
}