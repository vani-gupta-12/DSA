class Solution {
    public int maxDistance(int[] colors) {
        int n = colors.length, i = 0, j = n-1;
        while(colors[0] == colors[j]){
            --j;
        }
        while(colors[n-1] == colors[i]){
            ++i;
        }
        return Math.max(j, n-i-1);
    }
}