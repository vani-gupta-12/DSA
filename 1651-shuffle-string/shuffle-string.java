class Solution {
    public String restoreString(String s, int[] indices) {
        int n = indices.length;
        /*int count = 0;
        for(int i=0; i<n-1; i++){
            if(indices[i] < indices[i+1]) count++;
        }
        if (count == n) return s;*/
        char[] a = new char[n];
        for (int i=0; i<n;i++){
            a[indices[i]] = s.charAt(i);
        }
        return new String(a);
    }
}