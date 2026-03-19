class NumArray {
    public int[] st;
    public int n;
    public void build(int i,int s,int e, int[] nums){
        if (s==e){
            st[i] = nums[s];
            return;
        }
        int mid = (s+e)/2;
        build(2*i+1,s,mid, nums);
        build(2*i+2, mid+1, e,nums);
        st[i] = st[2*i+1] + st[2*i+2];
    }
    public int query(int i,int s,int e,int l,int r){
        if (l<=s && r>=e) return st[i];     //fully
        else if (s>r || e<l) return 0;      //not
        else{                               //partially
            int mid = (s+e)/2;
            return query(2*i+1, s ,mid, l ,r) + query(2*i+2 , mid+1, e ,l,r);
        }
    }
    public NumArray(int[] nums) {
        n = nums.length;
        st = new int[4*n];
        build(0,0,n-1, nums);
    }
    
    public int sumRange(int left, int right) {
        return query(0,0,n-1,left,right);
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(left,right);
 */