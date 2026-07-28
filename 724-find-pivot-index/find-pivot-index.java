class Solution {
    public int pivotIndex(int[] nums) {
        int n = nums.length;
        int[] pre = new int[n];
        int[] s = new int[n];
        pre[0] = nums[0];
        s[n-1] = nums[n-1];
        for(int i=1;i<n; i++){
            pre[i]= pre[i-1] + nums[i];
        }
        for(int i=n-2;i>=0;i--){
            s[i] = s[i+1]+ nums[i];
        }
        for(int i=0; i<n;i++){
            
            if(pre[i]==s[i]) return i;
            
        }
        return -1;
    }
}