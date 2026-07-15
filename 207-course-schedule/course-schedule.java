class Solution {
    
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        int[] inDegree = new int[numCourses];
        for (int i =0; i<numCourses;i++) adj.add(new ArrayList<>());
        for(int[] pre : prerequisites){
            int a = pre[0];
            int b = pre[1];
            adj.get(b).add(a);
            inDegree[a]++;
        }
        return topo(adj, numCourses, inDegree);
    }
    public boolean topo(ArrayList<ArrayList<Integer>> adj, int numCourses, int[] inDegree){
        Queue<Integer> q = new LinkedList<>();
        int count = 0;
        for(int i=0; i<numCourses;i++){
            if(inDegree[i]==0){
                count++;
                q.add(i);
            }
        }
        while(!q.isEmpty()){
            int curr = q.poll();
            for(int neigh : adj.get(curr)){
                inDegree[neigh]--;
                if(inDegree[neigh]==0){
                    count++;
                    q.add(neigh);
                }
            }
        }
        return (count==numCourses);
    }
}