package 其他;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author qijun
 * @Description
 * @Date 9:02 2022/6/19
 */
public class SonMax {
    public int max = 0;
    public int[] findFrequentTreeSum(TreeNode root) {
        Map<Integer,Integer> map = new HashMap();
        List<Integer> list = new ArrayList();
        dfs(map,root);
        for(Map.Entry<Integer,Integer> entry : map.entrySet()){
            if(entry.getValue() == max){
                list.add(entry.getKey());
            }

        }
        int[] result = new int[list.size()];
        for(int i= 0; i <list.size(); i++){
            result[i] = list.get(i);

        }
        return result;

    }

    public Integer  dfs(Map<Integer,Integer> map, TreeNode root){
        if(root == null){
            return null;
        }
        int result = root.val;
        Integer left = dfs(map, root.left);

        Integer right = dfs(map, root.right);

        if(left != null){
            result += left;
        }
        if(right != null){
            result += right;
        }
        if(map.containsKey(result)){
            Integer count = map.get(result) + 1;
            if(count > max){
                max = count;
            }
            map.put(result, count);
        }else{
            if(1 > max){
                max = 1;
            }
            map.put(result,1);
        }
        return result;


    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        TreeNode left = new TreeNode(2);
        TreeNode right = new TreeNode(-3);
        root.left = left;
        root.right = right;

        SonMax sonMax = new SonMax();
        sonMax.findFrequentTreeSum(root);
    }

}
