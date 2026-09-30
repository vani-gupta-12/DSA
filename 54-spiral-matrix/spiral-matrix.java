class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int top = 0;
        int left = 0;
        int down = n-1;
        int right = m-1;
        ArrayList<Integer> ans = new ArrayList<>();
        while(top <= down && right >= left){
            for(int i=left; i<=right; i++){
                ans.add(matrix[top][i]);
                
            }
            top++;
            for(int i=top; i<=down; i++){
                ans.add(matrix[i][right]);
                
            }
            right--;
            if(top<=down){
                for(int i=right; i>=left; i--){
                    ans.add(matrix[down][i]);
                }
                down--;
            }
            
            if(left<=right){
                for(int i=down; i>=top; i--){
                    ans.add(matrix[i][left]);
                
                }
                left++;
            }
            
        }
        return ans;

    }
}