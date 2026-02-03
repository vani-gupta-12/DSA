class Solution {
    public int[] productExceptSelf(int[] nums) {
        int prod = 1;
        int count = 0;
        int n = nums.length;
        int[] ans = new int[n];
        for (int i=0 ;i<n; i++){
            if (nums[i]==0){
                count++;
            }
            if (nums[i]==0){
                continue;
            }
            prod*= nums[i];
            
        }
        for (int i=0; i<n; i++){
            if (count==0){
                ans[i] = prod/nums[i];
            }else if (count==1){
                if (nums[i]==0){
                    ans[i] = prod;
                }else{
                    ans[i] =0;
                }
            }else{
                ans[i] = 0;
            }
        }
        return ans;
    }
}