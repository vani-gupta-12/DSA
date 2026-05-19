class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        ArrayList<Integer> ans = new ArrayList<>();
        int[] parent = new int[n];
        int dp[] = new int[n];
        Arrays.fill(dp,1);
        for (int i=0; i<n;i++){
            parent[i] = i;
        }
        int maxLen = 1;
        int last = 0;
        for(int i=0; i<n; i++){
            for(int j=0; j<i; j++){
                if(nums[i] % nums[j] ==0 && dp[j]+1 > dp[i]){
                    dp[i] = dp[j]+1;
                    parent[i] = j;
                }
            }
            if(dp[i]>maxLen){
                maxLen = dp[i];
                last = i;
            }
        }
        int curr = last;
        while (curr != parent[curr]){
            ans.add(nums[curr]);
            curr = parent[curr];
        }
        ans.add(nums[curr]);
        Collections.reverse(ans);
        return ans;
    }
}