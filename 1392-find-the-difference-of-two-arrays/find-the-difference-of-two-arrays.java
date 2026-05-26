class Solution {
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        List<List<Integer>> ans = new ArrayList<>();
        HashSet<Integer> set1 = new HashSet<>();
        HashSet<Integer> set2 = new HashSet<>();
        for(int i : nums1){
            set1.add(i);
        }
        for (int i : nums2){
            set2.add(i);
        }
        
        HashSet<Integer> st1 = new HashSet<>(set1);
        st1.removeAll(set2);
        set2.removeAll(set1);
        ans.add(new ArrayList<>(st1));
        ans.add(new ArrayList<>(set2));
        return ans;

        
    }
}