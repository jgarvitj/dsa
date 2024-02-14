/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    TreeNode lca  = null;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode[] nodes) {

        Set<Integer> nodeSet = new HashSet<>();
        for(TreeNode node : nodes) {
            nodeSet.add(node.val);
        }
        findNodeCount(root, nodeSet);
        return lca;
    }

    private int findNodeCount(TreeNode root, Set<Integer> nodes) {
        if(root == null) {
            return 0;
        }
        int leftCount = findNodeCount(root.left, nodes);
        int rightCount = findNodeCount(root.right, nodes);
        int foundCount = leftCount + rightCount;
        if(nodes.contains(root.val)) {
            foundCount++;
        }
        if(foundCount == nodes.size() && lca == null) {
            lca = root;
        }
        return foundCount;
    }
}
