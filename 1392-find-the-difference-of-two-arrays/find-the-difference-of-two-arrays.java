class Solution {
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        List<List<Integer>> ans = new ArrayList<>();
        for (int i=0; i<2;i++) ans.add(new ArrayList<>());
        HashSet<Integer> set1 = new HashSet<>();
        HashSet<Integer> set2 = new HashSet<>();
        for(int i : nums1){
            set1.add(i);
        }
        for (int i : nums2){
            set2.add(i);
        }
        
        for(int item : set1){
            if(!set2.contains(item)) ans.get(0).add(item);
        }
        for(int item : set2){
            if(!set1.contains(item)) ans.get(1).add(item);
        }
        return ans;
        
    }
}