package 二叉树;

import tree.TreeNode;

import java.util.*;

/**
 * @author qijun
 * @Description
 * @Date 20:44 2022/6/22
 */
public class FindBottomLeftValue {

    public static int findBottomLeftValue(TreeNode root) {
        Deque<TreeNode> queue = new LinkedList();

        queue.add(root);
        int leastVal = root.val;
        while(queue.size() != 0){
            int size = queue.size();
            // System.out.println("size=" + size);
            for(int i =0; i< size; i++){
                TreeNode node = queue.poll();
                if(i == 0){
                    leastVal = node.val;
                }
                if(node.left != null){


                    // System.out.println("node left =" + node.left.val);
                    queue.add(node.left);
                }
                if(node.right != null){
                    //   System.out.println("node right=" + node.right.val);
                    queue.add(node.right);
                }


            }
        }

        return leastVal;
    }
    //
    //public static void main(String[] args) {
    //    //TreeNode treeNode = new TreeNode(1);
    //    //TreeNode treeNode1 = new TreeNode(2);
    //    //
    //    //TreeNode treeNode2 = new TreeNode(3);
    //    //
    //    //TreeNode treeNode3 = new TreeNode(4);
    //    //
    //    //treeNode.left = treeNode1;
    //    //treeNode.right = treeNode2;
    //    //
    //    //treeNode1.left = treeNode3;
    //    //findBottomLeftValue(treeNode);
    //
    //
    //    System.out.println(1e9 );
    //
    //    Random random = new Random();
    //    random.nextInt(5);
    //
    //    Arrays.sort();
    //
    //
    //
    //}

    public static boolean isIn(int[] blacklist, int result){
        if(blacklist.length == 0){
            return false;
        }
        int begin = 0;
        int end = blacklist.length - 1;
        int big = -1;
        while(begin <= end){
            int middle = begin + (end-begin)/2;
            if(blacklist[middle] == result){
                return true;
            }else if(middle > result){
                end = middle -1;
            }else{
                begin =middle + 1;
            }

        }
        return false;


    }

    public static void main(String[] args) {
        int[] blacklist = {0,2};
        System.out.println(isIn(blacklist,1));
        Set<Integer> set = new HashSet<>();
        List list = new ArrayList(set);
        String s = "11111111";

    }
}
