class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int start = 1;
        int end = 0;
        int ans = 0;
        for (int i : piles) end = Math.max(i,end);
        while (start <= end){
            int mid = start + (end - start )/2;
            int sum = 0;
            for(int i : piles){
                sum += Math.ceil((double)i/mid);
            }
            if (sum <= h){
                ans = mid;
                end = mid-1;
            }else start = mid+1;
        }
        return ans;
    }
}