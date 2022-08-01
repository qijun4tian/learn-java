package search.二分;

public class 二分查找 {

    public static int search(int[] nums, int target) {

        int length = nums.length;
        int begin = 0;
        int end = length -1;
        while (begin <= end){
            int middle =begin + (end - begin)/2;
            if(nums[middle] == target){
                return target;
            }else if(nums[middle] > target){
                end = middle -1;
            }else {
                begin = middle + 1;
            }

        }
        return -1;

    }

    public static void main(String[] args) {
        int[] nums = {-1,0,3,5,9,12};

    }
}
