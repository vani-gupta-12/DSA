class Solution {
    public int largestAltitude(int[] gain) {
        int n = gain.length;
        int[] pre = new int[n+1];
        pre[0] = 0;
        int max =0 ;
        for (int i=1; i<pre.length; i++){
            pre[i] = pre[i-1] + gain[i-1];
            if (pre[i] > max){
                max = pre[i];
            }
        }
        return max;
    }
}