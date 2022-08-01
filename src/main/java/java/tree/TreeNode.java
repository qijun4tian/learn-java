package java.tree;

/**
 * @Author:qijun
 * @Description
 * @Date 23:31 2021/12/24
 */
public class TreeNode {

    public int val;
    public TreeNode left;


    public TreeNode right;

    public TreeNode(){

    }

    public TreeNode(int x) {
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
