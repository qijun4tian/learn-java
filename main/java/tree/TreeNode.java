package tree;

/**
 * @Author:qijun
 * @Description
 * @Date 23:31 2021/12/24
 */
public class TreeNode {

    int val;
    TreeNode left;


    TreeNode right;

    TreeNode(int x) {
        val = x;
    }


    @Override
    public String toString() {
        return "TreeNode{" +
                "val=" + val +
                ", left=" + left +
                ", right=" + right +
                '}';
    }
}
