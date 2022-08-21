package java.其他;

/**
 * @author qijun
 * @Description
 * @Date 22:32 2022/6/20
 */
public class MergeArray {

    public int[][] merge(int[][] intervals) {
        int length = intervals.length;
        boolean[] bools = new boolean[length];
        int count = length;
        for (int i = 0; i < length; i++) {
            for (int j = i +1; j < length; j++) {
                if (!(intervals[i][1] < intervals[j][0]
                        || intervals[i][0] > intervals[j][1])) {
                    int left = Math.min(intervals[i][0], intervals[j][0]);
                    int right = Math.max(intervals[i][1], intervals[j][1]);
                    intervals[j][0] = left;
                    intervals[j][1] = right;
                    bools[i] = true;
                    count--;
                    break;

                }
            }
        }
        int[][] result = new int[count][2];
        for (int i = 0, j = 0; i < bools. length ; i++) {
            if (!bools[i]) {
                result[j++] = intervals[i];
            }
        }
        return result;

    }

    public static void main(String[] args) {
        MergeArray mergeArray = new MergeArray();
        int[][] arr = {{1,3},{2,6},{8,10},{15,18}};
        mergeArray.merge(arr);
    }
}
