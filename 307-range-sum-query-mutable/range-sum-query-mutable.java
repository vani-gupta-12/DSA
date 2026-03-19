class NumArray{
    public int[] st;
    public int n;
    public void build(int i, int s , int e, int[] nums){
        if (s==e){
            st[i] = nums[s];
            return;
        }
        int mid = (s+e)/2;
        build(2*i+1, s, mid, nums);
        build(2*i+2, mid+1, e, nums);
        st[i] = st[2*i+1] + st[2*i+2];
    }
    public int query(int i, int s, int e, int l, int r){
        if (l<=s && r>=e) return st[i];
        else if(r<s || e<l) return 0;
        else{
            int mid = (s+e)/2;
            return query(2*i+1, s,mid, l ,r) + query(2*i+2,mid+1 , e,l,r);
        }
    }
    public void update(int index, int val, int i, int s, int e){
        if (s==e){
            st[i] = val;
            return;
        }
        int mid = (s+e)/2;
        if (index<=mid) update(index, val, 2*i+1, s,mid);
        else update(index,val,2*i+2, mid+1,e);
        st[i] = st[2*i+1]  + st[2*i+2];
    }
    public NumArray(int[] nums) {
        n = nums.length;
        st = new int[4*n];
        build(0,0,n-1,nums);
    }
    
    public void update(int index, int val) {
        update(index,val,0,0,n-1);
    }
    
    public int sumRange(int left, int right) {
        return query(0,0,n-1,left,right);
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(index,val);
 * int param_2 = obj.sumRange(left,right);
 */