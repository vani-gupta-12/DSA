class MyHashSet {
    boolean[] ans;
    public MyHashSet() {
        ans = new boolean[1000001];
    }
    
    public void add(int key) {
        ans[key] = true;
    }
    
    public void remove(int key) {
        ans[key] = false;
    }
    
    public boolean contains(int key) {
        return ans[key]==true;
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */