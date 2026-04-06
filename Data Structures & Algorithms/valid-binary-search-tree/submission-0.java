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
    public boolean isValidBST(TreeNode root) {
        return valid(root,null,null);
       
        
        
    }
    public boolean valid(TreeNode node, Integer low, Integer high){
        if(node==null){
            return true;
        }
        if(low!=null && low>=node.val || high!=null && high<=node.val){
            return false;
        }
        return valid(node.left, low, node.val)&& valid(node.right, node.val, high);

    }
}
