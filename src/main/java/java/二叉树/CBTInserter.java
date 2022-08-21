package java.二叉树;

import tree.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author qijun
 * @date 2022/7/25 20:55
 */
public class CBTInserter {
    int level = 0;
    Deque<TreeNode> last = new LinkedList();
    Deque<TreeNode> curList = new LinkedList();
    TreeNode root = null;
    TreeNode cur = null;


    public CBTInserter(TreeNode root) {

        this.root = root;
        Deque<TreeNode> deque = new LinkedList();
        curList = deque;
        deque.add(root);
        while(deque.size() != 0){
            int size = deque.size();
            last = new LinkedList<>();
            for(int i= 0;i< size; i++){
                TreeNode temp = deque.poll();
                last.add(temp);
                if(temp.left == null){
                    continue;
                }
                if(temp.left != null){
                    cur = last.poll();
                    deque.add(temp.left);
                }
                if(temp.right != null){
                    deque.add(temp.right);
                    cur = null;
                }

            }
            int count = (int)Math.pow(2,++level);
            if(deque.size() != count) {
                if(deque.size() == 0){
                    cur = last.poll();
                }
                break;
            }
        }

    }

    public int insert(int val) {
        TreeNode node = new TreeNode(val);
        int count = (int)Math.pow(2,level);
        int rVal = 0;
        curList.add(node);
        if(cur == null){
            cur = last.poll();

        }
        rVal = cur.val;
        if(curList.size() == count){
            cur.right = node;
            last = curList;
            curList = new LinkedList();
            cur = last.poll();
            level++;

        }else {
            if(cur.left == null){
                cur.left = node;
            }else{
                cur.right = node;
                cur = last.poll();

            }

        }
        return rVal;

    }

    public TreeNode get_root() {

        return root;

    }

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1);
        TreeNode treeNode1 = new TreeNode(2);
        TreeNode treeNode2 = new TreeNode(3);
        TreeNode treeNode3 = new TreeNode(4);
        TreeNode treeNode4 = new TreeNode(5);
        //TreeNode treeNode5 = new TreeNode(6);
        //
        treeNode.left = treeNode1;
        treeNode.right = treeNode2;
        treeNode1.left = treeNode3;
        treeNode1.right = treeNode4;
        //treeNode2.left = treeNode5;
        CBTInserter cbtInserter = new CBTInserter(treeNode);
        System.out.println(cbtInserter.insert(6));
        //System.out.println(cbtInserter.insert(8));
        TreeNode root = cbtInserter.get_root();

        System.out.println(root);











        //TreeNode treeNode = new TreeNode(1);
        //TreeNode treeNode1 = new TreeNode(2);
        //TreeNode treeNode2 = new TreeNode(3);
        //
        //treeNode.left = treeNode1;
        //treeNode.right = treeNode2;
        //
        //CBTInserter cbtInserter = new CBTInserter(treeNode);
        //System.out.println(cbtInserter.insert(4));
        ////System.out.println(cbtInserter.insert(8));
        //TreeNode root = cbtInserter.get_root();



        //TreeNode treeNode = new TreeNode(1);
        //TreeNode treeNode1 = new TreeNode(2);
        //TreeNode treeNode2 = new TreeNode(3);
        //TreeNode treeNode3 = new TreeNode(4);
        //
        ////
        //treeNode.left = treeNode1;
        //treeNode.right = treeNode2;
        //treeNode1.left = treeNode3;
        ////treeNode1.right = treeNode4;
        ////treeNode2.left = treeNode5;
        //CBTInserter cbtInserter = new CBTInserter(treeNode);
        //System.out.println(cbtInserter.insert(5));
        //System.out.println(cbtInserter.insert(6));
        //TreeNode root = cbtInserter.get_root();

    }
}
