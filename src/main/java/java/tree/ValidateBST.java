package java.tree;

/**
 * 中序遍历二叉搜索树是顺序的，
 * 验证二叉搜索树
 * @author qijun
 * @date 2021/11/15 8:46
 */
public class ValidateBST {

    TreeNode previous;
    public Boolean validateBST(TreeNode root){
        if(root == null){
            return true;
        }
        if(!validateBST(root.left)){
            return false;
        }
        if(previous != null && previous.val >= root.val){
            return false;
        }
        previous = root;
        if(!validateBST(root.right)){
            return false;
        }
        return true;
    }

}
