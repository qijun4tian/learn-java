package 二叉树;

import tree.TreeNode;

import java.util.Map;
import java.util.TreeMap;

public class ConstructMaximumBinaryTree {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        TreeMap<Integer,Integer> treeMap = new TreeMap<>((a1,a2)-> Integer.compare(a2,a1));
        for (int i = 0; i < nums.length; i++) {
            treeMap.put(nums[i],i);
        }
        return buildTree(nums,0,nums.length-1,treeMap);

    }

    private TreeNode buildTree(int[] nums, int begin, int end, TreeMap<Integer,Integer> treeMap){
        if(begin > end){
            return null;
        }
        if(end == begin){
            return new TreeNode(nums[begin]);
        }
        int middle = -1;
        int key = -1;
        TreeNode treeNode = null;
        for (Map.Entry<Integer, Integer> entry : treeMap.entrySet()) {
            if(entry.getValue() >= begin &&
              entry.getValue() <= end ){
                key = entry.getKey();
                middle = entry.getValue();
                treeNode = new TreeNode(key);
                break;
            }
        }

        treeMap.remove(key);
        treeNode.left = buildTree(nums,begin,middle -1,treeMap);
        treeNode.right = buildTree(nums,middle+1,end,treeMap);
        return treeNode;


    }

    public static void main(String[] args) {
        ConstructMaximumBinaryTree constructMaximumBinaryTree = new ConstructMaximumBinaryTree();
        TreeNode treeNode = constructMaximumBinaryTree.constructMaximumBinaryTree(new int[]{3, 2, 1, 6, 0, 5});
    }
}
