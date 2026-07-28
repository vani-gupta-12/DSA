class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> set = new HashSet<>();
        ArrayList<Integer> ans = new ArrayList<>();
        for(int i : nums1){
            set.add(i);
        }
        for(int i : nums2){
            if(set.contains(i)){
                ans.add(i);
                set.remove(i);
            }
        }
        int[] res = new int[ans.size()];
        for(int i=0; i<ans.size();i++){
            res[i] = ans.get(i);
        }
        return res;
    }
}