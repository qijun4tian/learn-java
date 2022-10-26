package array;

import java.util.stream.IntStream;

public class IsExistDuplicatedNums {
    public boolean containsDuplicate(int[] nums) {
        return IntStream.of(nums).distinct().count() != nums.length;


    }
}
