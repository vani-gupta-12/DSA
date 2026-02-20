class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;
        ArrayList<Integer> ans = new ArrayList<>();
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        int inDegree[] = new int[n];
        for (int i=0;i<n;i++) adj.add(new ArrayList<>());
        for (int i =0; i<n; i++){
            for (int j : graph[i]){
                adj.get(j).add(i);
                inDegree[i]++;
            }
        }
        Queue<Integer> q = new LinkedList<>();
        boolean[] isVis = new boolean[n];
        for (int i=0;i<n;i++){
            if (inDegree[i]==0) {
                q.add(i);
            }
        }
        while (!q.isEmpty()){
            int curr = q.poll();
            ans.add(curr);
            for (int i=0;i<adj.get(curr).size();i++){
                int neigh = adj.get(curr).get(i);
                inDegree[neigh]--;
                if (inDegree[neigh] == 0) q.add(neigh);
            }
        }
        Collections.sort(ans);
        return ans;
    }
}