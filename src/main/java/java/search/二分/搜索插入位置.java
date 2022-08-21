package java.search.二分;

public class 搜索插入位置 {

    public int searchInsert(int[] nums, int target) {
        int begin = 0;
        int end = nums.length -1;
        int result = 0;
        while (begin <= end){
            int middle = begin + (end -begin)/2;
            result = middle;
            if(nums[middle] == target){
                return middle;
            }else if(nums[middle] > target){
                end = middle -1;
            }else {
                begin = middle + 1;
            }

        }
        return nums[result] > target ? result : result +1;

    }
}
