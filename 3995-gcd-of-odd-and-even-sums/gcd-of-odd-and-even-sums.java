class Solution {
    public int gcdOfOddEvenSums(int n) {
        int even = 0;
        int odd = 0;
        for (int i=0; i<=2*n;i++){
            if (i%2==0) even += i;
            else odd += i;
        }
        while (even>0 && odd > 0){
            if (even > odd){
                even %= odd;
            }else odd %= even;
            if (even == 0) return odd;
        }
        return even;
    }
}