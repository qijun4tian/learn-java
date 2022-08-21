package java.其他;

/**
 * @author qijun
 * @Description
 * @Date 9:03 2022/6/19
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
