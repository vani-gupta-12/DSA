class Solution {
    public String gcdOfStrings(String str1, String str2) {
        int n = str1.length();
        int m = str2.length();
        if(!(str1+str2).equals(str2+str1)) return "";
        int g = gcd(n,m);
        return str1.substring(0,g); 
    }
    public int gcd(int a, int b){
        return (b==0) ? a : gcd(b,a%b);
    }
}