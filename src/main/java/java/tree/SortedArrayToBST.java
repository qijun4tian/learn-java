package java.tree;

/**
 *
 *
 * 输入：nums = [-10,-3,0,5,9]
 * 输出：[0,-3,9,-10,null,5]
 * 解释：[0,-10,5,null,-3,null,9] 也将被视为正确答案
 *
 * 作者：力扣 (LeetCode)
 * 链接：https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/xninbt/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 * https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/xninbt/
 * @author qijun
 * @date 2021/11/18 15:56
 *
 */
public class SortedArrayToBST {
    public TreeNode sortedArrayToBST(int[] nums) {
        if(nums.length == 0){
            return null;
        }
        return sortedArrayToBST1(nums, 0,nums.length -1);

    }

    public TreeNode sortedArrayToBST1(int[] nums,int begin, int end) {
        if(begin > end){
            return null;
        }
        int mid = (begin + end) >> 1;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = sortedArrayToBST1(nums,begin,mid-1);
        root.right = sortedArrayToBST1(nums,mid+1,end);
        return root;
    }

}
