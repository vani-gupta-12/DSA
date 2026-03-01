class Solution {
    public int findGCD(int[] nums) {
        Arrays.sort(nums);
        int a = nums[0];
        int b = nums[nums.length-1];
        while (a>0 && b>0){
            if (a>b) a %= b;
            else b %= a;
            if (a==0) return b;
        }
        return a;
    }
}