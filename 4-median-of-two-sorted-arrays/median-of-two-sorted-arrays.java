class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        ArrayList<Integer> ans = new ArrayList<>();
        for (int x : nums1) ans.add(x);
        for(int x : nums2) ans.add(x);
        Collections.sort(ans);
        int n = ans.size();
        if(n%2==1) return (ans.get(n/2));
        else return (ans.get(n/2-1) + ans.get(n/2))/2.0;
    }
}