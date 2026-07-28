class Solution {
    public int distributeCandies(int[] candyType) {
        int n = candyType.length/2;
        HashSet<Integer> set = new HashSet<>();
        for(int i : candyType){
            set.add(i);
        }
        if(set.size()>=n) return n;
        else return set.size();
    }
}