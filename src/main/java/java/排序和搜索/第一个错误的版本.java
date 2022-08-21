package java.排序和搜索;

/**
 * @Author:qijun
 * @Description
 * @Date 16:45 2021/11/27
 */
public class 第一个错误的版本 {
    public static int firstBadVersion(int n) {
        int begin = 1;
        int end = n;
        int midle = begin  + (end -begin)/2;
        int first = n;
        while (begin  <= end) {
            if (isBadVersion(midle)) {
                end = midle - 1;
                first = midle;
                midle = begin  + (end -begin)/2;
            } else {
                begin = midle + 1;
                midle = begin  + (end -begin)/2;
            }
        }
        System.out.println(first);
        return first;

    }

    private static boolean isBadVersion(int n){
        return n >= 1;
    }

    public static void main(String[] args) {
        firstBadVersion(3);
    }


}
