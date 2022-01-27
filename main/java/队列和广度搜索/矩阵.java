package 队列和广度搜索;

import java.util.*;

/**
 * @author:qijun
 * @Description https://leetcode-cn.com/leetbook/read/queue-stack/g7pyt/
 * @Date 12:52 2022/1/23
 */
public class 矩阵 {
    private int k1;
    private int k2;

    public static int[][] updateMatrix1(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int[][] result = new int[m][n];
        int[][] v = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 0) {
                    result[i][j] = 0;
                } else {
                    result[i][j] = -1;
                }
                v[i][i] = 0;
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (result[i][j] != -1) {
                    getLeastStep(result, i, j, m, n, mat, v);
                }

            }
        }
        return result;
    }

    public static Integer getLeastStep(int[][] result, int i, int j, int m, int n, int[][] mat, int[][] v) {
        v[i][j] = 1;

        if (result[i][j] != -1) {
            return result[i][j];
        } else {
            int temp1 = 10000;
            int temp2 = 10000;
            int temp3 = 10000;
            int temp4 = 10000;
            if (i - 1 >= 0 && v[i - 1][j] == 0) {
                temp1 = getLeastStep(result, i - 1, j, m, n, mat, v) + 1;
            }
            if (i + 1 < m && v[i + 1][j] == 0) {
                temp2 = getLeastStep(result, i + 1, j, m, n, mat, v) + 1;
            }
            if (j + 1 < n && v[i][j + 1] == 0) {
                temp3 = getLeastStep(result, i, j + 1, m, n, mat, v) + 1;
            }
            if (j - 1 >= 0 && v[i][j - 1] == 0) {
                temp4 = getLeastStep(result, i, j - 1, m, n, mat, v) + 1;
            }
            result[i][j] = Math.min(Math.min(Math.min(temp1, temp2), temp3), temp4);

            return result[i][j];
        }


    }

    public static void main(String[] args) {
        int[][] a = {{0, 1, 0, 1, 1}, {1, 1, 0, 0, 1}, {0, 0, 0, 1, 0}, {1, 0, 1, 1, 1}, {1, 0, 0, 0, 1}};
        int[][] ints = updateMatrix1(a);
        for (int i = 0; i < ints.length; i++) {
            System.out.println("\r\n----------");
            for (int i1 = 0; i1 < ints[i].length; i1++) {
                System.out.print(ints[i][i1]);
            }
        }
    }
    //public static void main(String[] args) {
    //    int[][] a = {{0, 0, 0}, {0, 1, 0}, {0, 0, 0}};
    //    int[][] ints = updateMatrix(a);
    //    for (int i = 0; i < ints.length; i++) {
    //        System.out.println("\r\n----------");
    //        for (int i1 = 0; i1 < ints[i].length; i1++) {
    //            System.out.print(ints[i][i1]);
    //        }
    //    }
    //}


    public static int[][] updateMatrix(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int[][] result = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                result[i][j] = -1;
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (result[i][j] != -1) {
                    continue;
                }
                if (mat[i][j] == 0) {
                    result[i][j] = 0;
                } else {
                    bfs(result, i, j, mat, m, n);
                }
            }
        }
        return result;
    }

    private static void bfs(int[][] result, int i, int j, int[][] mat, int m, int n) {
        Deque<List<Integer>> deque = new LinkedList<>();
        Deque<StringBuilder> deque2 = new LinkedList<>();
        int min = -1;
        int[][] visited = new int[m][n];
        StringBuilder s = new StringBuilder();
        addDequeu(i, j, deque, visited, s, deque2);

        StringBuilder end = null;

        while (!deque.isEmpty()) {
            int size = deque.size();
            min++;
            for (int i1 = 0; i1 < size; i1++) {
                List<Integer> pop = deque.pop();
                int tempi = pop.get(0);
                int tempj = pop.get(1);
                StringBuilder pop1 = deque2.pop();
                if (mat[tempi][tempj] == 0) {
                    end = pop1;
                    deque.clear();
                    break;
                } else {
                    if (tempi - 1 >= 0 && visited[tempi - 1][tempj] == 0) {
                        addDequeu(tempi - 1, tempj, deque, visited, pop1, deque2);
                    }
                    if (tempi + 1 < m && visited[tempi + 1][tempj] == 0) {
                        addDequeu(tempi + 1, tempj, deque, visited, pop1, deque2);
                    }
                    if (tempj + 1 < n && visited[tempi][tempj + 1] == 0) {
                        addDequeu(tempi, tempj + 1, deque, visited, pop1, deque2);
                    }
                    if (tempj - 1 >= 0 && visited[tempi][tempj - 1] == 0) {
                        addDequeu(tempi, tempj - 1, deque, visited, pop1, deque2);
                    }

                }
            }
        }
        if (min != 0) {
            String[] split = end.toString().split(",");
            System.out.println(end.toString());
            for (int i1 = 0; i1 < split.length; i1++) {
                int tempi = Integer.parseInt(split[i1]);
                int tempj = Integer.parseInt(split[++i1]);
                result[tempi][tempj] = min--;


            }
        }


    }

    //[[0],[1]]

    private static void addDequeu(int i, int j, Deque<List<Integer>> deque, int[][] visited, StringBuilder s, Deque<StringBuilder> deque2) {
        List<Integer> list = new ArrayList<>();
        list.add(i);
        list.add(j);
        deque.add(list);
        visited[i][j] = 1;
        if (s.length() == 0) {
            StringBuilder append = new StringBuilder(s).append(i).append(",").append(j);
            deque2.add(append);
        } else {
            StringBuilder append = new StringBuilder(s).append(",").append(i).append(",").append(j);
            deque2.add(append);
        }


    }


    class Solution {
        static int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        public int[][] updateMatrix(int[][] matrix) {
            int m = matrix.length, n = matrix[0].length;
            int[][] dist = new int[m][n];
            boolean[][] seen = new boolean[m][n];
            Queue<int[]> queue = new LinkedList<int[]>();
            // 将所有的 0 添加进初始队列中
            for (int i = 0; i < m; ++i) {
                for (int j = 0; j < n; ++j) {
                    if (matrix[i][j] == 0) {
                        queue.offer(new int[]{i, j});
                        seen[i][j] = true;
                    }
                }
            }

            // 广度优先搜索
            while (!queue.isEmpty()) {
                int[] cell = queue.poll();
                int i = cell[0], j = cell[1];
                for (int d = 0; d < 4; ++d) {
                    int ni = i + dirs[d][0];
                    int nj = j + dirs[d][1];
                    if (ni >= 0 && ni < m && nj >= 0 && nj < n && !seen[ni][nj]) {
                        dist[ni][nj] = dist[i][j] + 1;
                        queue.offer(new int[]{ni, nj});
                        seen[ni][nj] = true;
                    }
                }
            }

            return dist;
        }
    }


}
