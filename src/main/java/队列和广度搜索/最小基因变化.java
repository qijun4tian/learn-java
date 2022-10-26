package 队列和广度搜索;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author qijun
 * @Description
 * @Date 13:12 2022/5/8
 */
public class 最小基因变化 {

    public static int minMutation(String start, String end, String[] bank) {
        int differnetNum = differentce(start, end);
        if (differnetNum == 0) {
            return 0;
        }
        boolean[] visited = new boolean[bank.length];
        Deque<String> queue = new LinkedList();
        queue.add(start);
        int step = 0;
        while (queue.size() != 0) {
            int size = queue.size();
            step++;
            for (int k = 0; k < size; k++) {
                String temp = queue.pop();
                for (int j = 0; j < bank.length; j++) {
                    if (!visited[j]) {
                        if (differentce(temp, bank[j]) == 1) {

                            if (bank[j].equals(end)) {
                                return step;
                            } else {
                                queue.add(bank[j]);
                                visited[j] = true;
                            }

                        }
                    }
                }
            }
        }
        return -1;

    }


    public static int differentce(String start, String end) {
        int step = 0;
        for (int i = 0; i < 8; i++) {
            if (start.charAt(i) != end.charAt(i)) {
                step++;
            }
        }
        return step;
    }

    public static void main(String[] args) {
        String[] s = {"AACCGGTA", "AACCGCTA", "AAACGGTA"};
        minMutation("AACCGGTT", "AAACGGTA", s);
        String s1 = "111";
        s1.length();
    }
}
