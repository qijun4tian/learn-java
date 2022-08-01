package tree;

import sun.misc.PostVMInitHook;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/populating-next-right-pointers-in-each-node/
 *
 * @Author:qijun
 * @Description
 * @Date 21:42 2021/12/23
 */
public class 填充每个节点的下一个右侧节点指针 {

    public static Node connect(Node root) {
        if (root == null) {
            return root;
        }
        List<Node> lastNodes = new ArrayList<>();
        root.next = null;
        lastNodes.add(root);
        connect1(lastNodes);
        return root;


    }

    public static void connect1(List<Node> lastNodes) {
        if (lastNodes.get(0).right == null) {
            return;
        }
        List<Node> lastNode1 = new ArrayList<>();
        for (Node lastNode : lastNodes) {
            lastNode.left.next = lastNode.right;
            if (lastNode.next != null) {
                lastNode.right.next = lastNode.next.left;
            } else {
                lastNode.right.next = null;
            }
            lastNode1.add(lastNode.left);
            lastNode1.add(lastNode.right);
        }
        connect1(lastNode1);
    }


    public static class Node {
        int val;
        Node left;
        Node right;
        Node next;

        public Node(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {

        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        Node node6 = new Node(6);
        Node node7 = new Node(7);
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.left = node6;
        node3.right = node7;

        connect(node1);

        System.out.println(111);


    }
}
