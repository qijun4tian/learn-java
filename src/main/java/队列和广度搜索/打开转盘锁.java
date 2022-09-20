package 队列和广度搜索;

import java.util.*;

/**
 * @Author:qijun
 * @Description
 * @Date 22:01 2022/1/6
 */
public class 打开转盘锁 {

    public static int openLock(String[] deadends, String target) {
        Set<String> exitStrings = new HashSet<>();
        int result = -1;
        Queue<String> queue = new LinkedList<>();
        queue.add("0000");
        exitStrings.add("0000");
        if (Arrays.asList(deadends).contains("0000")) {
            return -1;
        }
        while (!queue.isEmpty()) {
            System.out.println("----------" + String.join(",", exitStrings));
            result++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String poll = queue.poll();
                System.out.println(poll);

                if (poll.equals(target)) {
                    return result;
                }
                for (int i1 = 0; i1 < poll.length(); i1++) {
                    char c = poll.charAt(i1);
                    int i2 = c - '0';
                    Integer before = getBefore(i2);
                    String stringBefore = poll.substring(0, i1) + before.toString() + poll.substring(i1 + 1);
                    if (!exitStrings.contains(stringBefore) && Arrays.stream(deadends).noneMatch(e -> e.equals(stringBefore))) {
                        queue.add(stringBefore);
                        exitStrings.add(stringBefore);
                    }
                    Integer after = getAfter(i2);
                    String stringAfter = poll.substring(0, i1) + after.toString() + poll.substring(i1 + 1);
                    if (!exitStrings.contains(stringAfter) && Arrays.stream(deadends).noneMatch(e -> e.equals(stringAfter))) {
                        queue.add(stringAfter);
                        exitStrings.add(stringAfter);
                    }
                }
            }
        }
        return -1;
    }

    public static Integer getBefore(Integer a) {
        return (a + 9) % 10;
    }

    public static Integer getAfter(Integer a) {
        return (a + 1) % 10;
    }

    public static void main(String[] args) {
        String[] a = {"8887", "8889", "8878", "8898", "8788", "8988", "7888", "9888"};
        String target = "8888";
        System.out.println(openLock(a, target));
    }
}
