package tree;

import sort.linkedlistsort.ListNode;

import java.util.ArrayList;
import java.util.List;

public class BinarySearchTreeToGreaterSumtree {

    class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
    }

    int sum = 0;

    public TreeNode bstToGst(TreeNode root){
        int a[] = {0};
        rightMiddleSearch(root,a);
        return root;
    }
    public void rightMiddleSearch(TreeNode treeNode,int a[] ){
        if(treeNode != null){
            if(treeNode.right != null){
                rightMiddleSearch(treeNode.right,a);
            }
            a[0] += treeNode.val;
            treeNode.val = a[0];
            if(treeNode.left != null){
                rightMiddleSearch(treeNode.left,a);
            }

        }
    }

    public TreeNode bstToGst1(TreeNode root) {
        if(root != null){
            bstToGst(root.right);
            sum = sum + root.val;
            root.val = sum;
            bstToGst(root.left);
        }
        return root;

    }


    public static void main(String[] args) {
        int a[] = {3};
        changeValue(a);
        System.out.println(a[0]);

    }


    public static  void changeValue(int a[]){
        a[0] += 3;
    }

}
