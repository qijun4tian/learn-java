package tree;

/**
 * 二叉树中序遍历一定是有序的
 * @author qijun
 * @date 2021/8/9 8:28
 *
 * source https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/xn08xg/
 */
public class 验证二叉搜索树 {
    TreeNode preview = null;

    // [5,4,6,null,null,3,7]
    public boolean isValidBST(TreeNode root) {
        if(root == null){
            return true;
        }
        if(!isValidBST(root.left)){
            return false;
        }

        if(preview != null && preview.val >= root.val){
            return false;
        }
        preview = root;
        if(!isValidBST(root.right)){
            return false;
        }
        return true;

    }


}
