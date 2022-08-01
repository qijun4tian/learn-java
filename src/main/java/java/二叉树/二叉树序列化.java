package java.二叉树;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author qijun
 * @date 2022/5/11 19:03
 */
public class 二叉树序列化 {

    // Encodes a tree to a single string.
    public static String serialize(TreeNode root) {
        if(root == null){
            return "";
        }
        List<String> result = new ArrayList<>();

        Deque<TreeNode> deque = new LinkedList<>();
        deque.add(root);

        while (!deque.isEmpty()){
            int size = deque.size();
            boolean isAllNull = true;
            for(int i = 0; i<size;i++){
                TreeNode pop = deque.pop();
                if(pop == null){
                    result.add("null");
                }
                else  {
                    result.add(String.valueOf(pop.val));
                    if(pop.left != null || pop.right != null){
                        isAllNull = false;
                    }
                    deque.add(pop.left);
                    deque.add(pop.right);
                }

            }
            if(isAllNull){
                break;
            }
        }
        int end = result.size();
        for (int i = result.size() -1 ; i >= 0 ; i--) {
            if(!result.get(i).equals("null")){
                end = i;
                break;
            }
        }

        return String.join(",", result.subList(0,end+1));


    }

    // Decodes your encoded data to tree.
    public static TreeNode deserialize(String data) {
        if(data.length() == 0){
            return null;
        }
        Deque<TreeNode> deque = new LinkedList<>();
        String[] split = data.split(",");
        TreeNode head = new TreeNode(Integer.parseInt(split[0]));
        deque.add(head);
        int start = 0;
        while (!deque.isEmpty()){
            int size = deque.size();
            for (int i = 0; i < size; i++) {
                TreeNode poll = deque.poll();
                if(poll != null){
                    if(start == split.length -1) {
                        break;
                    }
                    String left = split[++start];
                    if (!left.equals("null")) {
                        poll.left = new TreeNode(Integer.parseInt(left));
                    }
                    if(start == split.length -1) {
                        break;
                    }
                    String right = split[++start];
                    if(!right.equals("null")){
                        poll.right = new TreeNode(Integer.parseInt(right));
                    }
                    deque.add(poll.left);
                    deque.add(poll.right);
                }
            }
            if(start == split.length -1){
                break;
            }
        }
        return head;



    }

    public static  TreeNode generateNode(String[] split, int i){
        if(i >= split.length){
            return null;
        }
        if(split[i].equals("null")){
            return null;
        }
        TreeNode treeNode = new TreeNode(Integer.parseInt(split[i]));
        treeNode.left = generateNode(split,2*i+1);
        treeNode.right = generateNode(split,2*i+2);
        return treeNode;
    }




    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1);
        TreeNode treeNode1 = new TreeNode(2);
        TreeNode treeNode2= new TreeNode(3);
        //TreeNode treeNode4 = new TreeNode(4);
        //TreeNode treeNode5= new TreeNode(5);
        treeNode.left = treeNode1;
        treeNode.right = treeNode2;
        //treeNode2.left = treeNode4;
        //treeNode2.right = treeNode5;
        System.out.println(serialize(treeNode));


        TreeNode deserialize = deserialize("1,2,3");

        System.out.println(deserialize);


    }
}
