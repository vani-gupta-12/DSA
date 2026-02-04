class Solution {
    public int numOfSubarrays(int[] arr, int k, int threshold) {
        int start = 0;
        int end =0;
        int count = 0;
        int sum =0;
        while (end < arr.length){
            sum += arr[end];
            if (end>=k-1){
                int avg = sum/k;
                if (avg>= threshold){
                    count++;
                }
                sum -= arr[start];
                start++;
            }
            end++;
        }
        return count;
    }
}