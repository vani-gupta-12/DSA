class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int start = 1;
        int end = 0;
        int ans =0;
        for (int i : weights){
            start = Math.max(start ,i);
            end += i;
        }
        while (start <= end){
            int mid = start + (end -start)/2;
            int count = 1;
            int sum = 0;
            for (int i : weights){
                if (sum+i > mid){
                    count++;
                    sum = i;
                }else{
                    sum += i;
                }
            }
            if(count<= days){
                ans = mid;
                end = mid-1;
            }else start = mid+1;
        }
        return ans;
    }
}