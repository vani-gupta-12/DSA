/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public void printLevelOrder(TreeNode root, List<List<Integer>> ans){
        Queue<TreeNode> q = new LinkedList<>();
        if (root!= null) q.add(root);
        while(!q.isEmpty()){
            int n= q.size();
            List<Integer> temp = new ArrayList<>();
            while(n!=0){
                TreeNode curr = q.poll();
                temp.add(curr.val);
                if(curr.left!= null) q.add(curr.left);
                if(curr.right!= null) q.add(curr.right);
                n--;
            }
            ans.add(temp);

        }
    }
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        printLevelOrder(root, ans);
        return ans;
    }
}