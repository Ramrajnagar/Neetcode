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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return lca(root,p,q);



        
    }
    private TreeNode lca(TreeNode node , TreeNode p ,TreeNode q){
        if(node==null || node==p || node==q){return node; }
        TreeNode left=lca(node.left,p,q);
        TreeNode right=lca(node.right,p,q);
        if(left!=null && right!=null){
            return node;
        }
        if(left!=null){
            return left;
        }else{
            return right;
        }

    }
}
