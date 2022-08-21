package java.tree;

/**
 * @Author:qijun
 * @Description
 * @Date 21:09 2021/11/14
 */
public class 验证二叉搜索树1 {
    TreeNode preview = null;

    public boolean isValidBST(TreeNode root) {

        if(root == null){
            return true;
        }
        if((root.left != null && root.left.val > root.val)
            || (root.right != null && root.right.val < root.val)){
            return false;
        }






        return true;

    }
}
